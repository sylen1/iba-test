package cz.iba.test;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfBirth;
    private Sex sex;

    public Student() {
    }

    public Student(String firstName, String lastName, Date dateOfBirth, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                '}';
    }
}
