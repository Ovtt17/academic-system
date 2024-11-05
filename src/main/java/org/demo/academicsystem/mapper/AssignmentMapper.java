package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.service.SubmissionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class AssignmentMapper {

    @Autowired
    private SubmissionService submissionService;

    @Mapping(target = "course", expression = "java(mapCourseIdToCourse(request.courseId()))")
    public abstract Assignment toEntity(AssignmentRequest request);

    @Mapping(target = "totalSubmissions", source = "id", qualifiedByName = "mapTotalSubmissions")
    public abstract AssignmentResponse toResponse(Assignment assignment);

    protected  Course mapCourseIdToCourse(Long courseId) {
        return Course.builder()
                .id(courseId)
                .build();
    }

    @Named("mapTotalSubmissions")
    protected Long mapTotalSubmissions(Long assignmentId) {
        return submissionService.countByAssignmentId(assignmentId);
    }
}
