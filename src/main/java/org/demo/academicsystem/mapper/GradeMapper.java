package org.demo.academicsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.grade.GradeRequest;
import org.demo.academicsystem.dto.grade.GradeResponse;
import org.demo.academicsystem.entity.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GradeMapper {
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;
    private final AssignmentMapper assignmentMapper;
    private final TeacherMapper teacherMapper;

    public Grade toEntity(GradeRequest request) {
        return Grade.builder()
                .grade(request.grade())
                .comments(request.comments())
                .assignment(
                        Assignment.builder()
                                .id(request.assignmentId())
                                .build()
                )
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
                .teacher(
                        Teacher.builder()
                                .id(request.teacherId())
                                .build()
                )
                .build();
    }

    public GradeResponse toResponse(Grade grade) {
        return GradeResponse.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .comments(grade.getComments())
                .student(studentMapper.toResponse(grade.getStudent()))
                .build();
    }
}
