package com.test.contactapp.services;

import com.test.contactapp.dtos.ContactDto;
import com.test.contactapp.exceptions.BadRequestException;
import com.test.contactapp.mappers.ContactMapper;
import com.test.contactapp.mocks.Mocks;
import com.test.contactapp.repository.ContactRepository;
import com.test.contactapp.service.ContactService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Swapnil Bagadia
 */

@RunWith(SpringRunner.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private ContactMapper contactMapper;

    @InjectMocks
    private ContactService contactService;

    @Before
    public void init() {
        Mockito.when(contactRepository.findByName(Mockito.any(String.class),Mockito.any())).thenReturn(Mocks.getContactsByName());
        Mockito.when(contactRepository.findByEmailId(Mockito.any(String.class))).thenReturn(Mocks.getContactsByEmailId());
    }


    @Test
    public void testInsertSuccess() throws BadRequestException {
        int rand = RandomUtils.nextInt();
        ContactDto contactDto = new ContactDto();
        contactDto.setEmailId(String.valueOf(rand)+"@xyz.com");
        contactDto.setMobileNumber("9191001919");
        contactService.insert(contactDto);
    }

}
