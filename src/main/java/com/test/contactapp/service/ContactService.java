package com.test.contactapp.service;

import com.test.contactapp.core.Contact;
import com.test.contactapp.dtos.ContactDto;
import com.test.contactapp.exceptions.BadRequestException;
import com.test.contactapp.mappers.ContactMapper;
import com.test.contactapp.repository.ContactRepository;
import com.test.contactapp.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Swapnil Bagadia
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    @Resource
    private ContactService self;

    public Object search(@RequestParam String query, Pageable pageable) {
        if (ValidationUtils.isValidEmailId(query)) {
            return self.findByEmailId(query);
        } else {
            Page<Contact> contacts = contactRepository.findByName(query, pageable);
            return contacts.stream().map(contact -> contactMapper.toDto(contact)).collect(Collectors.toList());
        }
    }

    @Cacheable("contacts")
    public ContactDto findByEmailId(String query) {
        return contactMapper.toDto(contactRepository.findByEmailId(query));
    }

    @CachePut("contacts")
    public void update(ContactDto contactDto) throws BadRequestException {
        Contact contact = contactRepository.findById(contactDto.getContactId()).get();
        if (Objects.nonNull(contact)) {
            contact = contactMapper.toEntity(contactDto, contact);
            saveContact(contact);
        } else {
            throw new BadRequestException("Not a valid ID");
        }

    }

    public void insert(ContactDto contactDto) throws BadRequestException {
        saveContact(contactMapper.toEntity(contactDto));
    }

    @CacheEvict(value = "contacts")
    public void delete(@RequestParam String emailId) {
        contactRepository.delete(contactRepository.findByEmailId(emailId));
    }

    private void saveContact(Contact contact) throws BadRequestException {
        try {
            contactRepository.saveAndFlush(contact);
        } catch (DataIntegrityViolationException de) {
            throw new BadRequestException(de.getMessage());
        }
    }

}
