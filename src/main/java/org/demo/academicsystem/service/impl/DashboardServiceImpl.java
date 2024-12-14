package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.dashboard.*;
import org.demo.academicsystem.service.*;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final AssignmentService assignmentService;
    private final CourseService courseService;
    private final StudentService studentService;
    private final AuthenticationService authenticationService;

    @Override
    public DashboardData getDashboardData(OAuth2AuthenticationToken authenticationToken) {
        var teacherInfo = authenticationService.getUserInfo(authenticationToken);

        List<CourseResponse> teacherCourses = courseService.getAllTeacherCourses(teacherInfo.email());
        List<TopStudent> top10Students = studentService.getTop10Students(teacherInfo.email());
        List<PendingAssignment> pendingAssignments = assignmentService.getPendingAssignments();
        List<WeeklyScoreByCourse> weeklyScores = assignmentService.getWeeklyScores(teacherInfo.email());

        return DashboardData.builder()
                .courses(
                        teacherCourses.stream()
                                .map(course -> TeacherCourseDetails.builder()
                                        .id(course.id())
                                        .name(course.name())
                                        .description(course.description())
                                        .build())
                                .collect(Collectors.toList())
                )
                .students(top10Students)
                .pendingAssignments(pendingAssignments)
                .weeklyScores(weeklyScores)
                .build();
    }
}
