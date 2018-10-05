package com.test.contactapp.mappers;

import com.test.contactapp.core.Contact;
import com.test.contactapp.dtos.ContactDto;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Swapnil Bagadia
 */
// @Component
// @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ContactsConverter implements Converter<Contact, ContactDto> {
    //
    // @Autowired
    // private ContactMapper contactMapper;

    @Override
    public ContactDto convert(Contact contact) {
        // return contactMapper.toDto(contact);
        if (contact == null) {
            return null;
        }
        ContactDto contactDto = new ContactDto();
        contactDto.setContactId(contact.getContactId());
        contactDto.setName(contact.getName());
        contactDto.setEmailId(contact.getEmailId());
        contactDto.setMobileNumber(contact.getMobileNumber());
        return contactDto;
    }
}
