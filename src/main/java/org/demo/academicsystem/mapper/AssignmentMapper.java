package org.demo.academicsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.service.SubmissionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentMapper {
    private final SubmissionService submissionService;
    public Assignment toEntity(AssignmentRequest request) {
        return Assignment.builder()
                .title(request.title())
                .description(request.description())
                .dueDate(request.dueDate())
                .course(
                        Course.builder()
                        .id(request.courseId())
                        .build()
                )
                .build();
    }

    public AssignmentResponse toResponse(Assignment assignment) {
        Long totalSubmissions = submissionService.countByAssignmentId(assignment.getId());
        return AssignmentResponse.builder()
                .id(assignment.getId())
                .title(assignment.getTitle())
                .description(assignment.getDescription())
                .dueDate(assignment.getDueDate())
                .status(assignment.getStatus())
                .totalSubmissions(totalSubmissions)
                .build();
    }
}
