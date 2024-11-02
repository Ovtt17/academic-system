package org.demo.academicsystem.entity;

import lombok.Getter;

@Getter
public enum AttendanceStatus {
    PRESENT("Present"),
    ABSENT("Absent"),
    LATE("Late");

    private final String status;

    AttendanceStatus(String status) {
        this.status = status;
    }
}