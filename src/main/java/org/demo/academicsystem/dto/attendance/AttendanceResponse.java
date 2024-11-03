package org.demo.academicsystem.dto.attendance;

import org.demo.academicsystem.entity.AttendanceStatus;

import java.time.LocalDate;

public record AttendanceResponse(
        Long id,
        String studentFullName,
        String courseName,
        LocalDate date,
        AttendanceStatus status
) {
}
