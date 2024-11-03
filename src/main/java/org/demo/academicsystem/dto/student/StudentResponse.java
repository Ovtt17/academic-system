package org.demo.academicsystem.dto.student;

import java.time.LocalDate;

public record StudentResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String gender,
        LocalDate dateOfBirth
) {
}
