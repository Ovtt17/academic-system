package org.demo.academicsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.enrollment.EnrollmentRequest;
import org.demo.academicsystem.dto.enrollment.EnrollmentResponse;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.Enrollment;
import org.demo.academicsystem.entity.Student;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper {
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    public Enrollment toEntity (EnrollmentRequest request) {
        return Enrollment.builder()
                .student(
                        Student.builder()
                        .id(request.studentId())
                        .build()
                )
                .course(
                        Course.builder()
                        .id(request.courseId())
                        .build()
                )
                .build();
    }

    public EnrollmentResponse toResponse(Enrollment enrollment) {
        return new EnrollmentResponse(
                enrollment.getId(),
                studentMapper.toResponse(enrollment.getStudent()),
                courseMapper.toResponse(enrollment.getCourse())
        );
    }
}
