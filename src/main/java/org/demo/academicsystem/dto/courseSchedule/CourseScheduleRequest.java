package org.demo.academicsystem.dto.courseSchedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record CourseScheduleRequest(
        @NotNull(message = "Day is mandatory")
        DayOfWeek day,

        @NotNull(message = "Start time is mandatory")
        LocalTime startTime,

        @NotNull(message = "End time is mandatory")
        LocalTime endTime,

        @NotBlank(message = "Course ID is mandatory")
        Long courseId
) {
}
