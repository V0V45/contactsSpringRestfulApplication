package com.contacts.app.model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* МОДЕЛЬ КОНТАКТА */
// Класс представляет собой модель контакта, которая состоит из имени, фамилии, номера телефона, почты и ID
public class Contact {
    // Поля
    private String name; // имя контакта
    private String surname; // фамилия контакта
    private String phoneNumber; // номер телефона контакта
    private String email; // email контакта
    private long id; // ID контакта
    private static final Pattern PHONE_NUMBER_REGEX = Pattern
            .compile("(\\+)?((\\d{2,3}) ?\\d|\\d)(([ -]?\\d)|( ?(\\d{2,3}) ?)){5,12}\\d"); // регулярное выражение для
                                                                                           // номера телефона
    private static final Pattern EMAIL_REGEX = Pattern.compile("[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}"); // регулярное
                                                                                                                   // выражение
                                                                                                                   // для
                                                                                                                   // email

    // Конструктор
    public Contact(String name, String surname, String phoneNumber, String email, long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        // для добавления номера телефона проверяем через регулярное выражение
        Matcher phoneMatcher = PHONE_NUMBER_REGEX.matcher(phoneNumber);
        if (phoneMatcher.matches()) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Номер телефона введен неправильно!");
        }
        // для добавления email проверяем через регулярное выражение
        Matcher emailMatcher = EMAIL_REGEX.matcher(email);
        if (emailMatcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("E-mail введен неправильно!");
        }
    }

    // Геттеры и сеттеры
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    // номера телефона можно засеттить только через регулярное выражение
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

    // почту можно засеттить только через регулярное выражение
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

    // Метод toString
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
