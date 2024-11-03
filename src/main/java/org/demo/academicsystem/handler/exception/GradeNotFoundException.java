package org.demo.academicsystem.handler.exception;

public class GradeNotFoundException extends RuntimeException {
  public GradeNotFoundException(String message) {
    super(message);
  }
}
