package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.dashboard.*;
import org.demo.academicsystem.service.AssignmentService;
import org.demo.academicsystem.service.CourseService;
import org.demo.academicsystem.service.DashboardService;
import org.demo.academicsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final AssignmentService assignmentService;
    private final CourseService courseService;
    private final StudentService studentService;

    @Override
    public DashboardData getDashboardData(Long teacherId) {
        List<CourseResponse> teacherCourses = courseService.getAllTeacherCourses(teacherId);
        List<TopStudent> top10Students = studentService.getTop10Students(teacherId);
        List<PendingAssignment> pendingAssignments = assignmentService.getPendingAssignments();
        List<WeeklyScoreByCourse> weeklyScores = assignmentService.getWeeklyScores(teacherId);

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
