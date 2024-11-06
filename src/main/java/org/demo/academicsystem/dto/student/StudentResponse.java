package org.demo.academicsystem.dto.student;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record StudentResponse(
        Long id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        Integer phone,
        String address,
        String gender,
        LocalDate dateOfBirth
) {
}
