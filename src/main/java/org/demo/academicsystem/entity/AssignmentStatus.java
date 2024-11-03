package org.demo.academicsystem.entity;

import lombok.Getter;

@Getter
public enum AssignmentStatus {
    OPEN("Open"),
    CLOSED("Closed");

    private final String status;

    AssignmentStatus(String status) {
        this.status = status;
    }
}
