package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String hometelephone;
    private final String mobiletelephone;
    private final String worktelephone;
    private final String email;
    private final String email2;
    private final String email3;

    public ContactData(String firstname, String lastname, String address, String hometelephone, String mobiletelephone, String worktelephone, String email, String email2, String email3) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.hometelephone = hometelephone;
        this.mobiletelephone = mobiletelephone;
        this.worktelephone = worktelephone;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHometelephone() {
        return hometelephone;
    }

    public String getMobiletelephone() {
        return mobiletelephone;
    }

    public String getWorktelephone() {
        return worktelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}
