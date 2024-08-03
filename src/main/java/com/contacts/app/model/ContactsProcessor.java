package com.contacts.app.model;

import java.util.ArrayList;

public class ContactsProcessor {
    private long CURRENT_MAX_ID;
    private ArrayList<Contact> contacts;
    
    public ContactsProcessor() {
        this.CURRENT_MAX_ID = 0L;
        this.contacts = new ArrayList<Contact>();
    }

    public long getCURRENT_MAX_ID() {
        return this.CURRENT_MAX_ID;
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void addContactToList(String contactName, String contactSurname, String contactEmail, String contactPhoneNumber) {
        Contact contactToAdd = new Contact(contactName, contactSurname, contactPhoneNumber, contactEmail, CURRENT_MAX_ID + 1);
        this.contacts.add(contactToAdd);
        CURRENT_MAX_ID += 1;
    }

    public void showAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void showContactById(int Id) {
        System.out.println(this.contacts.get(Id - 1).toString());
    }

    public void removeContactFromListById(int Id) {
        this.contacts.remove(Id - 1);
        for (int i = Id - 1; i < this.contacts.size(); i++) {
            this.contacts.get(i).setId(this.contacts.get(i).getId() - 1);
        }
        CURRENT_MAX_ID -= 1;
    }
    
    public void changeContactNameById(int Id, String name) {
        Contact currentContact = this.contacts.get(Id - 1);
        currentContact.setName(name);
    }

    public void changeContactSurnameById(int Id, String surname) {
        Contact currentContact = this.contacts.get(Id - 1);
        currentContact.setSurname(surname);
    }

    public void changeContactPhoneById(int Id, String phoneNumber) {
        Contact currentContact = this.contacts.get(Id - 1);
        currentContact.setPhoneNumber(new PhoneNumber(phoneNumber));
    }

    public void changeContactEmailById(int Id, String email) {
        Contact currentContact = this.contacts.get(Id - 1);
        currentContact.setEmail(new Email(email));
    }
}
