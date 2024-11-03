package org.demo.academicsystem.dto.dashboard;

import java.time.LocalDate;

public record PendingAssignment(
        Long id,
        String title,
        LocalDate dueDate,
        int submissions,
        int totalStudents
) {
}
