package com.contacts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contacts.app.model.ContactsProcessor;

@SpringBootApplication
public class ApplicationMain {

	public static void main(String[] args) {
		// SpringApplication.run(ApplicationMain.class, args);
		ContactsProcessor contactsProcessor = new ContactsProcessor();
		contactsProcessor.addContactToList("Loh", "Loshkov", "abc@ya.ru", "+79112281488");
		contactsProcessor.addContactToList("Cuckold", "Chmov", "oldcook@cuck.old", "+79113511515");
		contactsProcessor.addContactToList("Urod", "Gandonov", "petooh@chmo.ru", "+79112130010");
		contactsProcessor.addContactToList("Uebishe", "Lesnoe", "abcd@loshok.com", "+71231231212");
		contactsProcessor.showAllContacts();
		System.out.println("-----------");
		contactsProcessor.changeContactEmailById(1, "asd@asd.asd");
		contactsProcessor.showAllContacts();
		}
}
