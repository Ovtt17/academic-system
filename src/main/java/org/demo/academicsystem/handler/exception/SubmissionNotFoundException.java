package org.demo.academicsystem.handler.exception;

public class SubmissionNotFoundException extends RuntimeException {
  public SubmissionNotFoundException(String message) {
    super(message);
  }
}
