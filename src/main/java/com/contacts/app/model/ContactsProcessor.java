package com.contacts.app.model;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;

/* ПРОЦЕССОР КОНТАКТОВ */
// Класс представляет собой набор методов, которые позволяют управлять СПИСКОМ контактов
@Service
public class ContactsProcessor {
    // Поля
    private long CURRENT_MAX_ID; // текущий максимальный ID в списке контактов
    private ArrayList<Long> emptyContactsID; // список удаленных неиспользуемых ID (используется при удалении)
    private HashMap<Long, Contact> contacts; // коллекция ключ-значение <ID контакта: контакт>

    // Конструктор
    public ContactsProcessor() {
        this.CURRENT_MAX_ID = 0L; // стартовый максимальный ID - 0 (так как список изначально пустой)
        this.emptyContactsID = new ArrayList<Long>(); // стартовый список удаленных ID - пустой
        this.contacts = new HashMap<Long, Contact>(); // стартовый список контактов - пустой
    }

    // Геттеры
    public long getCURRENT_MAX_ID() {
        return this.CURRENT_MAX_ID;
    }

    public ArrayList<Long> getEmptyContactsID() {
        return this.emptyContactsID;
    }

    public HashMap<Long, Contact> getContacts() {
        return this.contacts;
    }

    // Методы
    // Добавить контакт в список
    public void addContactToList(String contactName, String contactSurname, String contactEmail,
            String contactPhoneNumber) {
        // если список удаленных ID пустой, то контакт будет добавляться в конец списка
        if (emptyContactsID.isEmpty()) {
            // создаем объект класса контакт с ID равным на единицу больше, чем текущий максимальный ID
            Contact contactToAdd = new Contact(contactName, contactSurname, contactPhoneNumber, contactEmail,
                    CURRENT_MAX_ID + 1);
            // кладем этот новоиспеченный контакт в коллекцию контактов в самый конец списка
            this.contacts.put(CURRENT_MAX_ID + 1, contactToAdd);
            // увеличиваем максимальный ID на единицу
            CURRENT_MAX_ID += 1;
        // если список удаленных ID НЕ пустой, то контакт будет добавляться на место удаленного контакта
        } else {
            // создаем объект класса контакт с ID равным первому из ранее удаленных ID
            Contact contactToAdd = new Contact(contactName, contactSurname, contactPhoneNumber, contactEmail,
                    emptyContactsID.getFirst());
            // кладем новоиспеченных контакт в коллекцию контактов в место, где образовался "разрыв"
            this.contacts.put(emptyContactsID.getFirst(), contactToAdd);
            // удаляем из списка удаленных ID только что использованный ID, чтобы показать, что "разрыв" мы заполнили
            this.emptyContactsID.removeFirst();
        }
    }

    // Вывести весь список контактов в консоль (для отладки)
    public void printAllContacts() {
        contacts.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    // Получить конкретный контакт по ID
    public Contact getContactById(long Id) {
        return this.contacts.get(Id);
    }

    // Удалить контакт из списка контактов по ID
    public void removeContactFromListById(long Id) {
        this.contacts.remove(Id);
        this.emptyContactsID.add(Id); // пополняем список удаленных ID для того, чтобы следующий новый контакт "закрыл дыру"
    }

    // Изменить имя контакта по ID
    public void changeContactNameById(long Id, String name) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setName(name);
    }

    // Изменить фамилию контакта по ID
    public void changeContactSurnameById(long Id, String surname) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setSurname(surname);
    }

    // Изменить телефон контакта по ID
    public void changeContactPhoneById(long Id, String phoneNumber) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setPhoneNumber(phoneNumber);
    }

    // Изменить email контакта по ID
    public void changeContactEmailById(long Id, String email) {
        Contact currentContact = this.contacts.get(Id);
        currentContact.setEmail(email);
    }
}
