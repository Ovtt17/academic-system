package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;
import org.demo.academicsystem.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CourseScheduleMapper.class, AssignmentMapper.class})
@Component
public interface CourseMapper {

    CourseScheduleMapper courseScheduleMapper = new CourseScheduleMapperImpl();

    @Mapping(target = "teacher", expression = "java(mapTeacherIdToTeacher(request.teacherId()))")
    @Mapping(target = "schedules", expression = "java(mapSchedules(request.schedules()))")
    Course toEntity(CourseRequest request);

    @Mapping(target = "totalStudents", expression = "java(course.getEnrollments() != null ? (long) course.getEnrollments().size() : 0L)")
    CourseResponse toResponse(Course course);

    default Teacher mapTeacherIdToTeacher(Long teacherId) {
        return Teacher.builder()
                .id(teacherId)
                .build();
    }

    default List<CourseSchedule> mapSchedules(List<CourseScheduleRequest> scheduleRequests) {
        return scheduleRequests.stream()
                .map(courseScheduleMapper::toEntity)
                .collect(Collectors.toList());
    }
}
