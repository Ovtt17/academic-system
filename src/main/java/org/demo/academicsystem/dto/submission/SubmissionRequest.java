package org.demo.academicsystem.dto.submission;

public record SubmissionRequest(
        Long assignmentId,
        Long studentId
) {
}
