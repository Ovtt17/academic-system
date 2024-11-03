package org.demo.academicsystem.dto.assignment;

import org.demo.academicsystem.entity.AssignmentStatus;

public record AssignmentResponse(
        Long id,
        String title,
        String description,
        String dueDate,
        AssignmentStatus status
) {
}
