package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<AssignmentResponse> getAllAssignments();
    Optional<AssignmentResponse> getAssignmentById(Long id);
    AssignmentResponse createAssignment(AssignmentRequest assignment);
    AssignmentResponse updateAssignment(Long id, AssignmentRequest assignment);
    boolean deleteAssigment(Long id);
}
