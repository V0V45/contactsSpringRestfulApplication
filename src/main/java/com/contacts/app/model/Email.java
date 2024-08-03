package com.contacts.app.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;
    private final Pattern emailRegEx = Pattern.compile("[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}");
    
    public Email(String email) {
        Matcher matcher = emailRegEx.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email введен неправильно!");
        }
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return this.email;
    }

}
