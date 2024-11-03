package org.demo.academicsystem.handler;

import org.demo.academicsystem.handler.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

import static org.demo.academicsystem.handler.BusinessErrorCodes.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ExceptionResponse> handleLockedException (LockedException e) {
        return ResponseEntity
                .status(UNAUTHORIZED)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(ACCOUNT_LOCKED.getCode())
                                .businessErrorDescription(ACCOUNT_LOCKED.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ExceptionResponse> handleDisabledException (DisabledException e) {
        return ResponseEntity
                .status(UNAUTHORIZED)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(ACCOUNT_DISABLED.getCode())
                                .businessErrorDescription(ACCOUNT_DISABLED.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleBadCredentialsException (BadCredentialsException e) {
        return ResponseEntity
                .status(UNAUTHORIZED)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(BAD_CREDENTIALS.getCode())
                                .businessErrorDescription(BAD_CREDENTIALS.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException (MethodArgumentNotValidException e) {
        Set<String> errors = new HashSet<>();
        e.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String errorMessage = error.getDefaultMessage();
                    errors.add(errorMessage);
                });
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(
                        ExceptionResponse.builder()
                                .validationErrors(errors)
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException (Exception e) {
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorDescription("Ha ocurrido un error inesperado, contacta con el administrador del sistema")
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(AssignmentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleAssignmentNotFoundException (AssignmentNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(ASSIGNMENT_NOT_FOUND.getCode())
                                .businessErrorDescription(ASSIGNMENT_NOT_FOUND.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTeacherNotFoundException (TeacherNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(TEACHER_NOT_FOUND.getCode())
                                .businessErrorDescription(TEACHER_NOT_FOUND.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCourseNotFoundException (CourseNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(COURSE_NOT_FOUND.getCode())
                                .businessErrorDescription(COURSE_NOT_FOUND.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(GradeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleGradeNotFoundException (GradeNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(GRADE_NOT_FOUND.getCode())
                                .businessErrorDescription(GRADE_NOT_FOUND.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(EnrollmentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEnrollmentNotFoundException (EnrollmentNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(ENROLLMENT_NOT_FOUND.getCode())
                                .businessErrorDescription(ENROLLMENT_NOT_FOUND.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(AttendanceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleAttendanceNotFoundException (AttendanceNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        ExceptionResponse.builder()
                                .businessErrorCode(ATTENDANCE_NOT_FOUND.getCode())
                                .businessErrorDescription(ATTENDANCE_NOT_FOUND.getDescription())
                                .error(e.getMessage())
                                .build()
                );
    }
}
