package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.submission.SubmissionRequest;
import org.demo.academicsystem.dto.submission.SubmissionResponse;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.entity.Student;
import org.demo.academicsystem.entity.Submission;
import org.springframework.stereotype.Component;

@Component
public class SubmissionMapper {
    public Submission toEntity (SubmissionRequest request) {
        return Submission.builder()
                .assignment(
                        Assignment.builder()
                                .id(request.assignmentId())
                                .build()
                )
                .student(
                        Student.builder()
                                .id(request.studentId())
                                .build()
                )
                .build();
    }

    public SubmissionResponse toResponse(Submission submission) {
        return SubmissionResponse.builder()
                .id(submission.getId())
                .assignmentId(submission.getAssignment().getId())
                .assignmentTitle(submission.getAssignment().getTitle())
                .studentId(submission.getStudent().getId())
                .studentName(submission.getStudent().getFullName())
                .submissionDate(submission.getSubmissionDate())
                .reviewed(submission.isReviewed())
                .build();
    }
}
