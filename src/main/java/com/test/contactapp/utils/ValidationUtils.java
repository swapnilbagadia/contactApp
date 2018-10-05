package com.test.contactapp.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author Swapnil Bagadia
 */
public class ValidationUtils {

    private static Pattern mobilePattern = Pattern.compile(RegexFormats.MOBILE);
    private static Pattern emailPattern = Pattern.compile(RegexFormats.EMAIL);
    private ValidationUtils() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        return !StringUtils.isBlank(mobileNumber) && mobilePattern.matcher(mobileNumber).matches();
    }

    public static boolean isValidEmailId(String emailId) {
        return !StringUtils.isBlank(emailId) && emailPattern.matcher(emailId).matches();
    }
}
