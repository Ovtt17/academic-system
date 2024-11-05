package org.demo.academicsystem.dto.assignment;

import org.demo.academicsystem.entity.AssignmentStatus;

import java.time.LocalDate;

public record AssignmentResponse(
        Long id,
        String title,
        String description,
        LocalDate dueDate,
        AssignmentStatus status,
        Long totalSubmissions
) {
}
