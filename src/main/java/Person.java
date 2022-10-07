import java.util.Objects;

public class Person {
    protected final String name; // не изменяется
    protected final String surname; // не изменяется
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public int happyBirthday() {
        if (hasAge()) {
            this.age += 1;
        }
        return 0;
    }

    public boolean hasAge() {
        if (age == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (this.address == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public void setAge(int ag) {
        if (ag >= 0 && ag < 200) {
            this.age = ag;
        } else {
            System.out.println("Такой возраст не может быть установлен ");
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        if (!hasAddress()) {
            return "Адрес не определен";
        } else {
            return address;
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() +
                " возраст: " + getAge() + " Проживает по адресу: " +
                getAddress() + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        Person o = (Person) obj;
        return name.equals(o.name) && surname.equals(o.surname);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setAge(0)
                .setSurname(surname)
                .setAddress(address);
        return personBuilder;
    }
}
