package org.demo.academicsystem.dto.submission;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SubmissionResponse(
        Long id,
        Long assignmentId,
        String assignmentTitle,
        Long studentId,
        String studentName,
        LocalDateTime submissionDate,
        boolean reviewed
) {
}
