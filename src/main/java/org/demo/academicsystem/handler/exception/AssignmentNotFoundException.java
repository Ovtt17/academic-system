package org.demo.academicsystem.handler.exception;

public class AssignmentNotFoundException extends RuntimeException {
    public AssignmentNotFoundException(String message) {
        super(message);
    }
}
