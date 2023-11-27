package Register;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    String name;
    String lastname;
    Integer documentNumber;
    Date birthday;

    public Person(String name, String lastname, Integer documentNumber, Date birthday) {
        this.name = name;
        this.lastname = lastname;
        this.documentNumber = documentNumber;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return "Name: " + name + ", Lastname: " + lastname + ", Document number: " + documentNumber + ", Birthday: "
                + formatDate.format(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
