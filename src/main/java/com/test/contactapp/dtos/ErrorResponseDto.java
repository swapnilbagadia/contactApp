package com.test.contactapp.dtos;

/**
 * @author Swapnil Bagadia
 */
public class ErrorResponseDto {

    private String message;

    public ErrorResponseDto(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
