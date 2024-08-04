package com.contacts.app.model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private long id;
    private static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("(\\+)?((\\d{2,3}) ?\\d|\\d)(([ -]?\\d)|( ?(\\d{2,3}) ?)){5,12}\\d");
    private static final Pattern EMAIL_REGEX = Pattern.compile("[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}");

    public Contact(String name, String surname, String phoneNumber, String email, long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        Matcher phoneMatcher = PHONE_NUMBER_REGEX.matcher(phoneNumber);
        if (phoneMatcher.matches()) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Номер телефона введен неправильно!");
        }
        Matcher emailMatcher = EMAIL_REGEX.matcher(email);
        if (emailMatcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("E-mail введен неправильно!");
        }
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
        Matcher phoneMatcher = PHONE_NUMBER_REGEX.matcher(phoneNumber);
        if (phoneMatcher.matches()) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Номер телефона введен неправильно!");
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        Matcher emailMatcher = EMAIL_REGEX.matcher(email);
        if (emailMatcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("E-mail введен неправильно!");
        }
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
