import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

    static Dog dog;

    @BeforeAll
    static void prepareDate(){
        dog = new Dog("Misha", 1);
    }

    @Test
    void testGetDogName() {
        assertEquals("Misha", dog.getName());
    }

    @Test
    void testSetDogName(){
        Dog dog1 = new Dog("", 1);
        dog1.setName("Mike");
        assertEquals("Mike", dog1.getName());
    }
}
