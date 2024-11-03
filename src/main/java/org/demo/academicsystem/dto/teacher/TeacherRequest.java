package org.demo.academicsystem.dto.teacher;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TeacherRequest(
        @NotBlank(message = "First name is mandatory")
        @Size(max = 50, message = "First name must be less than 50 characters")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        @Size(max = 50, message = "Last name must be less than 50 characters")
        String lastName,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,

        @NotNull(message = "Phone number is mandatory")
        @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
        Integer phone,

        LocalDate dateOfBirth,

        String profilePicture,

        LocalDate dateOfJoining,

        String department,

        String specialization
) {
}
