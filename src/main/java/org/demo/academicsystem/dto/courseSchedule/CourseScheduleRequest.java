package org.demo.academicsystem.dto.courseSchedule;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourseScheduleRequest(
        @NotNull(message = "Day is mandatory")
        LocalDate day,

        @NotNull(message = "Start time is mandatory")
        LocalTime startTime,

        @NotNull(message = "End time is mandatory")
        LocalTime endTime
) {
}
