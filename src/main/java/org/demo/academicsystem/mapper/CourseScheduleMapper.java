package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleResponse;
import org.demo.academicsystem.entity.CourseSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CourseScheduleMapper {
    CourseSchedule toEntity(CourseScheduleRequest request);
    CourseScheduleResponse toResponse(CourseSchedule schedule);
}
