public class PersonBuilder {

    private String name; // не изменяется
    private String surname; // не изменяется
    private int age;
    private String address;

    public Person build() throws IllegalStateException{
        Person person = new Person(name, surname);
        if(name == null || surname == null){
            RuntimeException e = new IllegalStateException("Ошибка у вас не заполнены имя или фамилия");
            throw e;
        }
        person.setAge(age);
        person.setAddress(address);
        return person;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст указан не корректно");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}
