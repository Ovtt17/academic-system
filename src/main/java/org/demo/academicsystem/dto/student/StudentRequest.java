package org.demo.academicsystem.dto.student;

import jakarta.validation.constraints.*;
import org.demo.academicsystem.entity.Gender;

import java.time.LocalDate;

public record StudentRequest(
        @NotBlank(message = "First name is mandatory")
        @Size(max = 50, message = "First name must be less than 50 characters")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        @Size(max = 50, message = "Last name must be less than 50 characters")
        String lastName,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        String email,

        @NotNull(message = "Phone number is mandatory")
        @Min(value = 10000000, message = "Phone number must be 8 digits")
        @Max(value = 99999999, message = "Phone number must be 8 digits")
        Integer phone,

        @NotBlank(message = "Address is mandatory")
        @Size(max = 100, message = "Address must be less than 100 characters")
        String address,

        @NotNull(message = "Date of birth is mandatory")
        LocalDate dateOfBirth,

        @NotNull(message = "Gender is mandatory")
        Gender gender
) {
}
