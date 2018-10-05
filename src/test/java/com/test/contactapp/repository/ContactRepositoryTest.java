package com.test.contactapp.repository;

import com.test.contactapp.core.Contact;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Swapnil Bagadia
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void whenFindByEmail_thenReturnContact() {
        //given
        Contact alex = new Contact("alex@abc.com");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Contact found = contactRepository.findByEmailId(alex.getEmailId());

        // then
        Assert.assertEquals(found.getEmailId(),alex.getEmailId());
    }

    @Test
    public void whenFindByName_thenReturnContactPage() {
        //given
        Contact alex = new Contact("alex@abc.com");
        Contact alex1 = new Contact("alex1@abc.com");
        Contact alex2 = new Contact("alex2@abc.com");
        Contact alex3 = new Contact("alex3@abc.com");
        entityManager.persist(alex);
        entityManager.persist(alex1);
        entityManager.persist(alex2);
        entityManager.persist(alex3);
        entityManager.flush();

        PageRequest page_req = new PageRequest(0, 3, Sort.Direction.DESC, "contactId");

        // when
        Page<Contact> found = contactRepository.findByName("TEST", page_req);

        Assert.assertEquals(3,found.getNumberOfElements());
    }

    @Test(expected = Exception.class)
    public void checkUniqueEmailConstraint() {
        //given
        Contact alex = new Contact("alex@abc.com");
        Contact alex1 = new Contact("alex@abc.com");

        entityManager.persist(alex);
        entityManager.persist(alex1);
        entityManager.flush();
    }
}
