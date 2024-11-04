package org.demo.academicsystem.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum BusinessErrorCodes {
    NO_CODE(0, NOT_IMPLEMENTED, "No se ha definido un código de error"),
    INCORRECT_CURRENT_PASSWORD (300, BAD_REQUEST, "La contraseña actual es incorrecta"),
    NEW_PASSWORD_DOES_NOT_MATCH (301, BAD_REQUEST, "Las contraseñas no coinciden"),
    ACCOUNT_LOCKED (302, FORBIDDEN, "La cuenta de usuario se encuentra bloqueada"),
    ACCOUNT_DISABLED (303, FORBIDDEN, "La cuenta de usuario se encuentra deshabilitada"),
    BAD_CREDENTIALS (304, FORBIDDEN, "La combinación de usuario y contraseña es incorrecta"),
    TEACHER_NOT_FOUND (305, NOT_FOUND, "Profesor no encontrado"),
    STUDENT_NOT_FOUND (306, NOT_FOUND, "Estudiante no encontrado"),
    COURSE_NOT_FOUND (307, NOT_FOUND, "Curso no encontrado"),
    ASSIGNMENT_NOT_FOUND (308, NOT_FOUND, "Tarea no encontrada"),
    GRADE_NOT_FOUND (309, NOT_FOUND, "Calificación no encontrada"),
    ENROLLMENT_NOT_FOUND (310, NOT_FOUND, "Matrícula no encontrada"),
    ATTENDANCE_NOT_FOUND (311, NOT_FOUND, "Asistencia no encontrada"),
    SUBMISSION_NOT_FOUND (312, NOT_FOUND, "Entrega no encontrada"),
    ;
    private final int code;
    private final String description;
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
