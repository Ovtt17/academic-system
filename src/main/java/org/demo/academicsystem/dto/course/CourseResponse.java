package org.demo.academicsystem.dto.course;

import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleResponse;
import org.demo.academicsystem.dto.teacher.TeacherResponse;

import java.util.List;

public record CourseResponse(
        Long id,
        String name,
        String description,
        String semester,
        List<CourseScheduleResponse> schedules,
        List<AssignmentResponse> assignments,
        Long totalStudents,
        TeacherResponse teacher
) {
}
