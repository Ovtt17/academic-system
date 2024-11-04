package org.demo.academicsystem.dto.dashboard;

import lombok.Builder;

import java.util.List;

@Builder
public record DashboardData(
        List<TeacherCourseDetails> courses,
        List<TopStudent> students,
        List<PendingAssignment> pendingAssignments,
        List<WeeklyScoreByCourse> weeklyScores
) {}