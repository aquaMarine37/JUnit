import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;
    @BeforeEach
    public void createCar(){
        car = new Car("Skoda", "MIR123", 2020, "Olya Ivanova");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("MIR123", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("MIR1234");
        assertEquals("MIR1234", car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"'MIR123', 'MIR123'", "'ABC34', 'ABCD34'"})
       void testSetNumberValues(String number, String x) {
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }

    @Test
     void getYear() {
        assertEquals(2020, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Olya Ivanova", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Ivan Ivanov");
        assertEquals("Ivan Ivanov", car.getOwner());
    }

    @Test
    void getListOfOwners(){
        assertArrayEquals(new String[]{"Olya Ivanova"}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners(){
        car.setOwner("Ivan Ivanov");
        assertArrayEquals(new String[]{"Olya Ivanova", "Ivan Ivanov"}, car.getOwners().toArray());
    }
    @Test
    public void testMethodPrice() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = Car.class.getDeclaredMethod("methodPrice",String.class);
            method.setAccessible(true);
            assertEquals(method.invoke(car, "price").toString(), "price");
    }
}