package org.demo.academicsystem.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

        @NotBlank(message = "Phone number is mandatory")
        @Size(min = 8, max = 8, message = "Phone number must be 8 characters")
        Integer phone,

        @NotBlank(message = "Address is mandatory")
        @Size(max = 100, message = "Address must be less than 100 characters")
        String address,

        @NotNull(message = "Date of birth is mandatory")
        LocalDate dateOfBirth,

        @NotBlank(message = "Gender is mandatory")
        Gender gender
) {
}
