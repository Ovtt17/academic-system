package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class AssignmentMapper {
    @Mapping(target = "course", expression = "java(mapCourseIdToCourse(request.courseId()))")
    public abstract Assignment toEntity(AssignmentRequest request);
    public abstract AssignmentResponse toResponse(Assignment assignment);

    protected Course mapCourseIdToCourse(Long courseId) {
        return Course.builder()
                .id(courseId)
                .build();
    }
}
