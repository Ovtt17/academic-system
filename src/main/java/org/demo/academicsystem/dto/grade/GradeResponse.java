package org.demo.academicsystem.dto.grade;

import lombok.Builder;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.dto.teacher.TeacherResponse;

@Builder
public record GradeResponse(
        Long id,
        Double grade,
        String comments,
        CourseResponse course,
        AssignmentResponse assignment,
        TeacherResponse teacher,
        StudentResponse student
) {
}
