package org.demo.academicsystem.dto.teacher;

import jakarta.validation.constraints.*;
import org.demo.academicsystem.entity.Gender;

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

        @NotBlank(message = "Username is mandatory")
        @Size(max = 20, message = "Username must be less than 50 characters")
        String username,

        @NotNull(message = "Phone number is mandatory")
        @Min(value = 10000000, message = "Phone number must be 8 digits")
        @Max(value = 99999999, message = "Phone number must be 8 digits")
        Integer phone,

        Gender gender,

        LocalDate dateOfBirth,

        String profilePicture,

        LocalDate dateOfJoining,

        String department,

        String specialization
) {
}
