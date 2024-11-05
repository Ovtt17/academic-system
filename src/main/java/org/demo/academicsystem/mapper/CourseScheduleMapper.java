package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleResponse;
import org.demo.academicsystem.entity.CourseSchedule;
import org.springframework.stereotype.Component;

@Component
public class CourseScheduleMapper {
    public CourseSchedule toEntity(CourseScheduleRequest request) {
        return CourseSchedule.builder()
                .day(request.day())
                .startTime(request.startTime())
                .endTime(request.endTime())
                .build();
    }

    public CourseScheduleResponse toResponse(CourseSchedule courseSchedule) {
        return CourseScheduleResponse.builder()
                .id(courseSchedule.getId())
                .day(courseSchedule.getDay())
                .startTime(courseSchedule.getStartTime())
                .endTime(courseSchedule.getEndTime())
                .build();
    }
}
