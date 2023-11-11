public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1 ;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 125){
            throw new IllegalArgumentException("Указан не неверный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build(){
        if (name == null || surname == null){
            throw new IllegalStateException ("Не указано Имя/Фамилия");
        }
        if (age < 0){
            Person person = new Person(name,surname);
            addAddress(person, address);
            return person;
        } else {
            Person person = new Person(name, surname, age);
            addAddress(person, address);
            return person;
        }
    }

    private void addAddress(Person person, String address){
        if (address != null){
            person.setAddress(address);
        }
    }

    @Override
    public String toString() {
        return "Name - " + name + "\n" +
                "Surname - " + surname + "\n" +
                "Age - " + ((age>=0) ? age : "unknown age") + "\n" +
                "Address - " + ((address != null) ? address : "unknown address");
    }
}
