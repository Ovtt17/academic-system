package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleResponse;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.CourseSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CourseScheduleMapper {

    @Mapping(target = "course", expression = "java(mapCourseIdToCourse(request.courseId()))")
    CourseSchedule toEntity(CourseScheduleRequest request);
    CourseScheduleResponse toResponse(CourseSchedule schedule);

    default Course mapCourseIdToCourse(Long courseId) {
        return Course.builder()
                .id(courseId)
                .build();
    }
}
