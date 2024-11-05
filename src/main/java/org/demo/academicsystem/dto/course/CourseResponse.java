package org.demo.academicsystem.dto.course;

import lombok.Builder;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleResponse;
import org.demo.academicsystem.dto.teacher.TeacherResponse;

import java.util.List;

@Builder
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
