package org.demo.academicsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.CourseSchedule;
import org.demo.academicsystem.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final CourseScheduleMapper courseScheduleMapper;
    private final AssignmentMapper assignmentMapper;
    private final TeacherMapper teacherMapper;

    public Course toEntity(CourseRequest request) {
        Course course = Course.builder()
                .name(request.name())
                .description(request.description())
                .section(request.section())
                .semester(request.semester())
                .teacher(Teacher.builder().id(request.teacherId()).build())
                .build();

        course.setSchedules(request.schedules().stream()
                .map(schedule -> {
                    CourseSchedule courseSchedule = courseScheduleMapper.toEntity(schedule);
                    courseSchedule.setCourse(course);
                    return courseSchedule;
                })
                .collect(Collectors.toList())
        );

        return course;
    }

    public CourseResponse toResponse(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .semester(course.getSemester())
                .schedules(course.getSchedules().stream()
                        .map(courseScheduleMapper::toResponse)
                        .collect(Collectors.toList())
                )
                .assignments(course.getAssignments().stream()
                        .map(assignmentMapper::toResponse)
                        .collect(Collectors.toList())
                )
                .totalStudents((long) course.getEnrollments().size())
                .teacher(
                        teacherMapper.toResponse(course.getTeacher())
                )
                .build();
    }
}
