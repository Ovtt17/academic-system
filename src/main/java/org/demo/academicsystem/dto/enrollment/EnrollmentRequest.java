package org.demo.academicsystem.dto.enrollment;

public record EnrollmentRequest(
        Long studentId,
        Long courseId
) {
}
