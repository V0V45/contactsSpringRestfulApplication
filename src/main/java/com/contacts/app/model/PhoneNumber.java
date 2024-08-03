package com.contacts.app.model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PhoneNumber {
    private String phoneNumber;
    private final Pattern phoneNumberRegex = Pattern.compile("(\\+)?((\\d{2,3}) ?\\d|\\d)(([ -]?\\d)|( ?(\\d{2,3}) ?)){5,12}\\d");

    public PhoneNumber(String phoneNumber) {
        Matcher matcher = phoneNumberRegex.matcher(phoneNumber);
        if (matcher.matches()) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Номер телефона введен неправильно!");
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return this.phoneNumber;
    }
    
}
