package org.demo.academicsystem.dto.dashboard;

import java.util.List;

public record DashboardData(
        List<TeachersCourse> courses,
        List<TopStudent> students,
        List<PendingAssignment> pendingAssignments,
        List<WeeklyScoreByCourse> weeklyScores
) {}