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

/* КЛАСС-КОНТРОЛЛЕР */
// Класс содержит все возможные пути работы с REST API
@RestController
@RequestMapping("/contacts") // весь API доступен по адресу .../contacts...
public class Controller {
    private ContactsProcessor contactsProcessor; // для создания списка контактов

    public Controller(ContactsProcessor contactsProcessor) { // конструктор создает список контактов (т.е. экземпляр
                                                             // класса ContactsProcessor)
        this.contactsProcessor = contactsProcessor;
    }

    // GET .../contacts
    // возвращает нам список контактов в формате JSON
    @GetMapping
    public HashMap<Long, Contact> getContacts() {
        return this.contactsProcessor.getContacts();
    }

    // GET .../contacts/{contactId}
    // возвращает конкретный контакт по ID
    @GetMapping("/{contactId}")
    public Contact getContactByID(@PathVariable long contactId) {
        return this.contactsProcessor.getContactById(contactId);
    }

    // POST .../contacts?name=...&surname=...&email=...&phone=...
    // создает контакт в списке контактов и возвращает список контактов по окончанию
    // процесса создания
    @PostMapping
    public HashMap<Long, Contact> createContact(@RequestParam String name, @RequestParam String surname,
            @RequestParam String email, @RequestParam String phone) {
        this.contactsProcessor.addContactToList(name, surname, email, phone);
        return this.contactsProcessor.getContacts();
    }

    // PUT .../contacts/{contactId}?name=...&surname=...&email=...&phone=...
    // (указывать все параметры не обязательно)
    // изменяет данные в ранее созданном контакте по ID
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

    // DELETE .../contacts/{contactId}
    // удаляет контакт по ID и на его месте создает "разрыв", т.е. ID всех остальных
    // контактов не изменяются, однако, при следующем добавлении контакта в список
    // он будет добавлен не в конец списка, а в "разрыв"
    @DeleteMapping("/{contactId}")
    public HashMap<Long, Contact> deleteContact(@PathVariable long contactId) {
        this.contactsProcessor.removeContactFromListById(contactId);
        return this.contactsProcessor.getContacts();
    }
}
