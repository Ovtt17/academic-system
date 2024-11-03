package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.CourseSchedule;
import org.demo.academicsystem.entity.Student;
import org.demo.academicsystem.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface CourseMapper {
    @Mapping(target = "students", expression = "java(mapStudentIdsToStudents(request.studentIds()))")
    @Mapping(target = "teacher", expression = "java(mapTeacherIdToTeacher(request.teacherId()))")
    @Mapping(target = "schedules", expression = "java(mapScheduleRequestToSchedule(request.schedules()))")
    Course toEntity(CourseRequest request);

    CourseResponse toResponse(Course course);

    default List<Student> mapStudentIdsToStudents(List<Long> studentIds) {
        return studentIds.stream()
                .map(id -> Student.builder()
                        .id(id)
                        .build())
                .collect(Collectors.toList());
    }

    default Teacher mapTeacherIdToTeacher(Long teacherId) {
        return Teacher.builder()
                .id(teacherId)
                .build();
    }

    default List<CourseSchedule> mapScheduleRequestToSchedule(List<CourseScheduleRequest> scheduleRequests) {
        return scheduleRequests.stream()
                .map(request -> CourseSchedule.builder()
                        .day(request.day())
                        .startTime(request.startTime())
                        .endTime(request.endTime())
                        .course(
                                Course.builder()
                                        .id(request.courseId())
                                        .build()
                        )
                        .build()
                ).toList();
    }
}
