package org.demo.academicsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.grade.GradeRequest;
import org.demo.academicsystem.dto.grade.GradeResponse;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.Grade;
import org.demo.academicsystem.entity.Student;
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

    public GradeResponse toResponse(Grade grade) {
        return GradeResponse.builder()
                .id(grade.getId())
                .grade(grade.getGrade())
                .comments(grade.getComments())
                .course(courseMapper.toResponse(grade.getCourse()))
                .assignment(assignmentMapper.toResponse(grade.getAssignment()))
                .teacher(teacherMapper.toResponse(grade.getTeacher()))
                .student(studentMapper.toResponse(grade.getStudent()))
                .build();
    }
}
