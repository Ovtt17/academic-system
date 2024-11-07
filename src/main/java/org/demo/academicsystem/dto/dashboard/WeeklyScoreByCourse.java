package org.demo.academicsystem.dto.dashboard;

public record WeeklyScoreByCourse(
        int week,
        double score,
        String courseName
) {
}
