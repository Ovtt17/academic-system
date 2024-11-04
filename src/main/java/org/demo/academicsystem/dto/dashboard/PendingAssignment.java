package org.demo.academicsystem.dto.dashboard;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PendingAssignment(
        Long id,
        String title,
        LocalDate dueDate,
        Long submissions,
        Long totalStudents
) {
}
