package org.demo.academicsystem.mapper;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.repository.CourseRepository;
import org.demo.academicsystem.service.SubmissionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentMapper {
    private final SubmissionService submissionService;
    private final CourseRepository courseRepository;

    public Assignment toEntity(AssignmentRequest request) {
        return Assignment.builder()
                .id(request.id())
                .title(request.title())
                .description(request.description())
                .dueDate(request.dueDate())
                .course(
                        courseRepository.findById(request.courseId())
                                .orElseThrow(() -> new IllegalArgumentException("Course not found"))
                )
                .build();
    }

    public AssignmentResponse toResponse(Assignment assignment) {
        Integer totalSubmissions = submissionService.countByAssignmentId(assignment.getId());
        Integer totalStudents = assignment.getCourse().getEnrollments().size();

        return AssignmentResponse.builder()
                .id(assignment.getId())
                .title(assignment.getTitle())
                .description(assignment.getDescription())
                .dueDate(assignment.getDueDate())
                .status(assignment.getStatus())
                .totalSubmissions(totalSubmissions)
                .totalStudents(totalStudents)
                .courseId(assignment.getCourse().getId())
                .build();
    }
}
