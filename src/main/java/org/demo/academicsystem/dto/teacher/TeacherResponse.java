package org.demo.academicsystem.dto.teacher;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public record TeacherResponse(
        Long id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        Integer phone,
        String profilePicture,
        LocalDate dateOfBirth,
        LocalDate dateOfJoining,
        String department,
        String specialization
) {
}
