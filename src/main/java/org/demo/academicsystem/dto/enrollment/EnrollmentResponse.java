package org.demo.academicsystem.dto.enrollment;

import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.student.StudentResponse;

public record EnrollmentResponse(
        Long id,
        StudentResponse student,
        CourseResponse course
) {
}
