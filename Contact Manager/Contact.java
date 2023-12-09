import java.time.LocalDate;
import java.time.Period;

public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.birthDate = "";
        this.age = 0;
    }

    public Contact(String name, String phoneNumber, String birthDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(this.birthDate);
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        setAge(this.birthDate);
    }

    public int toAge(String birthDate) {
        LocalDate birth = LocalDate.parse(birthDate);
        LocalDate currenDate = LocalDate.now();
        Period period = Period.between(birth, currenDate);
        int years = period.getYears();
        return years;
    }

    private void setAge(String birthDate) {
        this.age = toAge(birthDate);
    }

    public int getAge() {
        return this.age;
    }


    @Override
    public String toString() {
        return
            "name: " + getName() + "\n" +
            "phoneNumber: " + getPhoneNumber() + "\n" +
            "birthDate: " + getBirthDate() + "\n" +
            "age: " + this.age+ "\n";
    }

}