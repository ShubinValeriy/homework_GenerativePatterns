import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        if (age >= 0 && age <= 125) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Указан не неверный возраст");
        }
    }

    public void happyBirthday() {
        if (age >= 0) {
            age++;
        }
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (!hasAge()) {
            System.out.println("ВНИМАНИЕ: Возраст человека не известен. Будет возвращено значение -1");
        }
        return age;
    }

    public String getAddress() {
        if (!hasAddress()) {
            System.out.println("ВНИМАНИЕ: Адрес человека не известен. Будет возвращено значение Null");
        }
        return address;
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Name - " + name + "\n" +
                "Surname - " + surname + "\n" +
                "Age - " + ((hasAge()) ? age : "unknown age") + "\n" +
                "Address - " + ((hasAddress()) ? address : "unknown address");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person guest = (Person) obj;
        return name == guest.name && surname == guest.surname && age == guest.age && address == guest.address;
    }

}
