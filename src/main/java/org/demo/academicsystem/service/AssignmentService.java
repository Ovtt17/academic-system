package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.dto.dashboard.PendingAssignment;

import java.util.List;

public interface AssignmentService extends GenericService<AssignmentRequest, AssignmentResponse, Long> {
    List<PendingAssignment> getPendingAssignments();
}
