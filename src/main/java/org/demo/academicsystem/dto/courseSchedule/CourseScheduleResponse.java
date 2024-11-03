package org.demo.academicsystem.dto.courseSchedule;

import java.time.LocalDate;
import java.time.LocalTime;

public record CourseScheduleResponse(
        Long id,
        LocalDate day,
        LocalTime startTime,
        LocalTime endTime
) {
}
