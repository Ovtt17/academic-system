package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;

import java.util.List;

public interface AssignmentService {
    List<AssignmentResponse> getAllAssignments();
    AssignmentResponse getAssignmentById(Long id);
    AssignmentResponse createAssignment(AssignmentRequest assignment);
    AssignmentResponse updateAssignment(Long id, AssignmentRequest assignment);
    void deleteAssigment(Long id);
}
