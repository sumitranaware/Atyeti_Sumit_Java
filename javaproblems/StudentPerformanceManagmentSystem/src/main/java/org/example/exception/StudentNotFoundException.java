package org.example.exception;

import java.util.NoSuchElementException;

public class StudentNotFoundException extends NoSuchElementException {
    public StudentNotFoundException(String message){
        super(message);
    }
}
