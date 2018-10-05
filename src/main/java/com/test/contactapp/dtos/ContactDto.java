package com.test.contactapp.dtos;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Swapnil Bagadia
 */
public class ContactDto implements Serializable {

    private Long contactId;

    private String name;

    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Not valid email format.")
    private String emailId;

    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Not valid mobile number.")
    private String mobileNumber;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
