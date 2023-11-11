import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonBuilderTest {
    @Test
    void validateNegativeAge(){
        // given:
        int age = -10;
        PersonBuilder personBuilder = new PersonBuilder();
        // when:

        // then:
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personBuilder.setAge(age);
        });
    }

    @Test
    void validateNegativeBuild(){
        // given:
        String name = "Andrey";
        PersonBuilder personBuilder = new PersonBuilder();
        // when:

        // then:
        Assertions.assertThrows(IllegalStateException.class, () -> {
            personBuilder.setName(name).build();
        });
    }

    @Test
    void validateCorrectBuild(){
        // given:
        String name = "Andrey";
        String surname = "Petrov";
        int age = 30;
        String address = "Moscow, Petrovka, 7";
        PersonBuilder personBuilder = new PersonBuilder();

        // when:
        Person personExpected = new Person(name,surname,age);
        personExpected.setAddress(address);

        Person personIsValid = personBuilder
                .setName(name)
                .setSurname(surname)
                .setAge(age)
                .setAddress(address)
                .build();

        // then:
        Assertions.assertEquals(personExpected,personIsValid);
    }

}