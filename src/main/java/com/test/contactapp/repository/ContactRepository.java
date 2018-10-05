package com.test.contactapp.repository;

import com.test.contactapp.core.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Swapnil Bagadia
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmailId(String emailId);

    Page<Contact> findByName(String name, Pageable pageable);

    Contact saveAndFlush(Contact contact);

}
