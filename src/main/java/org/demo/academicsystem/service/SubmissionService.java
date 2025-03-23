package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.submission.SubmissionRequest;
import org.demo.academicsystem.dto.submission.SubmissionResponse;

public interface SubmissionService extends GenericService<SubmissionRequest, SubmissionResponse, Long> {
    Integer countByAssignmentId(Long assignmentId);
}
