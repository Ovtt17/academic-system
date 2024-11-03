package org.demo.academicsystem.dto.attendance;

import jakarta.validation.constraints.NotBlank;
import org.demo.academicsystem.entity.AttendanceStatus;

public record AttendanceRequest(
        @NotBlank(message = "Student ID is required")
        Long studentId,

        @NotBlank(message = "Course ID is required")
        Long courseId,

        @NotBlank(message = "Class Schedule ID is required")
        Long courseScheduleId,

        @NotBlank(message = "Attendance status is required")
        AttendanceStatus status
) {
}
