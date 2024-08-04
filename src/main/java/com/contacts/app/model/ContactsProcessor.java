package com.contacts.app.model;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ContactsProcessor {
    private long CURRENT_MAX_ID;
    private ArrayList<Long> emptyContactsID;
    private HashMap<Long, Contact> contacts;
    
    public ContactsProcessor() {
        this.CURRENT_MAX_ID = 0L;
        this.emptyContactsID = new ArrayList<Long>();
        this.contacts = new HashMap<Long, Contact>();
    }

    public long getCURRENT_MAX_ID() {
        return this.CURRENT_MAX_ID;
    }

    public ArrayList<Long> getEmptyContactsID() {
        return this.emptyContactsID;
    }

    public HashMap<Long, Contact> getContacts() {
        return this.contacts;
    }

    public void addContactToList(String contactName, String contactSurname, String contactEmail, String contactPhoneNumber) {
        if (emptyContactsID.isEmpty()) {
            Contact contactToAdd = new Contact(contactName, contactSurname, contactPhoneNumber, contactEmail, CURRENT_MAX_ID + 1);
            this.contacts.put(CURRENT_MAX_ID + 1, contactToAdd);
            CURRENT_MAX_ID += 1;
        } else {
            Contact contactToAdd = new Contact(contactName, contactSurname, contactPhoneNumber, contactEmail, emptyContactsID.getFirst());
            this.contacts.put(emptyContactsID.getFirst(), contactToAdd);
            this.emptyContactsID.removeFirst();
        }
    }

    public void printAllContacts() {
        contacts.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public Contact getContactById(long Id) {
        return this.contacts.get(Id);
    }

    public void removeContactFromListById(long Id) {
        this.contacts.remove(Id);
        this.emptyContactsID.add(Id);
    }
    
    public void changeContactNameById(long Id, String name) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setName(name);
    }

    public void changeContactSurnameById(long Id, String surname) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setSurname(surname);
    }

    public void changeContactPhoneById(long Id, String phoneNumber) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setPhoneNumber(phoneNumber);
    }

    public void changeContactEmailById(long Id, String email) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setEmail(email);
    }
}
