package org.demo.academicsystem.dto.attendance;

import lombok.Builder;
import org.demo.academicsystem.entity.AttendanceStatus;

import java.time.LocalDate;

@Builder
public record AttendanceResponse(
        Long id,
        String studentFullName,
        String courseName,
        LocalDate date,
        AttendanceStatus status
) {
}
