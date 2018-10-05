package com.test.contactapp.controller;

import com.test.contactapp.dtos.ContactDto;
import com.test.contactapp.exceptions.BadRequestException;
import com.test.contactapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Swapnil Bagadia
 */
@RestController
public class ContactAppController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public Object find(@RequestParam String query, @RequestParam String appSecret, @PageableDefault(size = 10) Pageable pageable) {
        return contactService.search(query, pageable);
    }

    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody ContactDto contactDto, @RequestParam String appSecret) throws BadRequestException {
        contactService.update(contactDto);
    }

    @PutMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody ContactDto contactDto, @RequestParam String appSecret) throws BadRequestException {
        contactService.insert(contactDto);
    }

    @DeleteMapping("/contact")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam String emailId, @RequestParam String appSecret) {
        contactService.delete(emailId);
    }

}
