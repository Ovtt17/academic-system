package org.demo.academicsystem.dto.teacher;

import java.time.LocalDate;
import java.util.Optional;

public record TeacherResponse(
        Long id,
        String firstName,
        String lastName,
        String fullName,
        String email,
        Optional<String> phone,
        Optional<String> profilePicture,
        Optional<LocalDate> dateOfBirth,
        Optional<LocalDate> dateOfJoining,
        Optional<String> department,
        Optional<String> specialization
) {
}
