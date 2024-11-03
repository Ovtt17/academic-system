package org.demo.academicsystem.dto.enrollment;

import lombok.Builder;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.student.StudentResponse;

@Builder
public record EnrollmentResponse(
        Long id,
        StudentResponse student,
        CourseResponse course
) {
}
