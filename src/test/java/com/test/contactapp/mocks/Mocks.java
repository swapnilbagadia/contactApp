package com.test.contactapp.mocks;

import com.test.contactapp.core.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Swapnil Bagadia
 */
public class Mocks {

    public static Page<Contact> getContactsByName() {
        Contact contact = new Contact("alex@xyz.com");
        Contact contact1 = new Contact("alex1@xyz.com");
        Contact contact2 = new Contact("alex2@xyz.com");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        contacts.add(contact1);
        contacts.add(contact2);
        return new PageImpl<>(contacts);
    }

    public static Contact getContactsByEmailId() {
        Contact contact = new Contact("alex@xyz.com");
        return contact;
    }
}
