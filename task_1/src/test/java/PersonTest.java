import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void happyBirthday() {
        // given:
        String name = "Andrey";
        String surname = "Petrov";
        int age = 30;
        int expectedAge = 31;
        Person person = new Person(name, surname, age);

        // when:
        person.happyBirthday();
        int isValidAge = person.getAge();


        // then:
        Assertions.assertEquals(expectedAge, isValidAge);

    }


    @ParameterizedTest
    @CsvSource({
            "true, true",
            "false, false"
    })
    public void hasAddress(boolean setAddress, boolean expected) {
        // given:
        String name = "Andrey";
        String surname = "Petrov";
        String address = "Moscow, Petrovka, 7";
        Person person = new Person(name, surname);

        // when:
        if (setAddress) {
            person.setAddress(address);
        }
        boolean isValid = person.hasAddress();

        // then:
        Assertions.assertEquals(expected, isValid);
    }

    @Test
    void negativeHasAge() {
        // given:
        String name = "Andrey";
        String surname = "Petrov";
        boolean expected = false;
        Person person = new Person(name, surname);

        // when:
        boolean isValid = person.hasAge();

        // then:
        Assertions.assertEquals(expected, isValid);
    }

    @Test
    void getNegativeAge() {
        // given:
        String name = "Andrey";
        String surname = "Petrov";
        int expectedAge = -1;
        Person person = new Person(name, surname);

        // when:
        int isValidAge = person.getAge();


        // then:
        Assertions.assertEquals(expectedAge, isValidAge);
    }

    @Test
    void getNegativeAddress() {
        // given:
        String name = "Andrey";
        String surname = "Petrov";
        String expectedAddress = null;
        Person person = new Person(name, surname);

        // when:
        String isValidAddress = person.getAddress();


        // then:
        Assertions.assertEquals(expectedAddress, isValidAddress);
    }
}