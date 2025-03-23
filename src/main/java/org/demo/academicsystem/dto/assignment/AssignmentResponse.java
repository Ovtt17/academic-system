package org.demo.academicsystem.dto.assignment;

import lombok.Builder;
import org.demo.academicsystem.entity.AssignmentStatus;

import java.time.LocalDate;

@Builder
public record AssignmentResponse(
        Long id,
        String title,
        String description,
        LocalDate dueDate,
        AssignmentStatus status,
        Integer totalSubmissions,
        Integer totalStudents,
        Long courseId
) {
}
