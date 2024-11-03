package org.demo.academicsystem.dto.course;

import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleResponse;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.dto.teacher.TeacherResponse;

import java.util.List;
import java.util.Optional;

public record CourseResponse(
        Long id,
        String name,
        String description,
        String semester,
        List<CourseScheduleResponse> schedules,
        Optional<List<AssignmentResponse>> assignments,
        List<StudentResponse> students,
        TeacherResponse teacher
) {
}
