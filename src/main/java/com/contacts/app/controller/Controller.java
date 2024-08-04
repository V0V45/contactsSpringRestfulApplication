package com.contacts.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.contacts.app.model.Contact;
import com.contacts.app.model.ContactsProcessor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.HashMap;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/contacts")
public class Controller {
    private ContactsProcessor contactsProcessor;

    public Controller(ContactsProcessor contactsProcessor) {
        this.contactsProcessor = contactsProcessor;
    }

    @GetMapping
    public HashMap<Long, Contact> getContacts() {
        return this.contactsProcessor.getContacts();
    }

    @GetMapping("/{contactId}")
    public Contact getContactByID(@PathVariable long contactId) {
        return this.contactsProcessor.getContactById(contactId);
    }

    @PostMapping
    public HashMap<Long, Contact> createContact(@RequestParam String name, @RequestParam String surname,
            @RequestParam String email, @RequestParam String phone) {
        this.contactsProcessor.addContactToList(name, surname, email, phone);
        return this.contactsProcessor.getContacts();
    }

    @PutMapping("/{contactId}")
    public Contact changeContactByID(@PathVariable long contactId, @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String surname, @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "") String phone) {
        if (!name.isEmpty()) {
            this.contactsProcessor.changeContactNameById(contactId, name);
        }
        if (!surname.isEmpty()) {
            this.contactsProcessor.changeContactSurnameById(contactId, surname);
        }
        if (!email.isEmpty()) {
            this.contactsProcessor.changeContactEmailById(contactId, email);
        }
        if (!phone.isEmpty()) {
            this.contactsProcessor.changeContactPhoneById(contactId, phone);
        }
        return this.contactsProcessor.getContacts().get(contactId);
    }

    @DeleteMapping("/{contactId}")
    public HashMap<Long, Contact> deleteContact(@PathVariable long contactId) {
        this.contactsProcessor.removeContactFromListById(contactId);
        return this.contactsProcessor.getContacts();
    }
}
