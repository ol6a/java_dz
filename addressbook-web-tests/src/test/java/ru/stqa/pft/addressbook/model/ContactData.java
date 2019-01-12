package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id  = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String address;
    private String hometelephone;
    private String mobiletelephone;
    private String worktelephone;
    private String email;
    private String email2;
    private String email3;

    public int getId() {
        return id;
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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHometelephone(String hometelephone) {
        this.hometelephone = hometelephone;
        return this;
    }

    public ContactData withMobiletelephone(String mobiletelephone) {
        this.mobiletelephone = mobiletelephone;
        return this;
    }

    public ContactData withWorktelephone(String worktelephone) {
        this.worktelephone = worktelephone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
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
