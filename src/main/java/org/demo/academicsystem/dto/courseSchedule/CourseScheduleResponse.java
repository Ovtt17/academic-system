package org.demo.academicsystem.dto.courseSchedule;

import lombok.Builder;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Builder
public record CourseScheduleResponse(
        Long id,
        DayOfWeek day,
        LocalTime startTime,
        LocalTime endTime
) {
}
