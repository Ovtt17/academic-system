package org.demo.academicsystem.dto.courseSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record CourseScheduleResponse(
        Long id,
        DayOfWeek day,
        LocalTime startTime,
        LocalTime endTime
) {
}
