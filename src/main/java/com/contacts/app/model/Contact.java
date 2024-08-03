package com.contacts.app.model;

public class Contact {
    private String name;
    private String surname;
    private PhoneNumber phoneNumber;
    private Email email;
    private long id;

    public Contact(String name, String surname, String phoneNumber, String email, long id) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

}
