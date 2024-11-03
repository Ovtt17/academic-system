package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.handler.exception.AssignmentNotFoundException;
import org.demo.academicsystem.mapper.AssignmentMapper;
import org.demo.academicsystem.repository.AssignmentRepository;
import org.demo.academicsystem.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;

    @Override
    public List<AssignmentResponse> getAllAssignments() {
        List<Assignment> assignments = assignmentRepository.findAll();
        return assignments.stream()
                .map(assignmentMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<AssignmentResponse> getAssignmentById(Long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        return assignment.map(assignmentMapper::toResponse);
    }

    @Override
    public AssignmentResponse createAssignment(AssignmentRequest assignment) {
        Assignment newAssigment = assignmentMapper.toEntity(assignment);
        Assignment savedAssigment = assignmentRepository.save(newAssigment);
        return assignmentMapper.toResponse(savedAssigment);
    }

    @Override
    public AssignmentResponse updateAssignment(Long id, AssignmentRequest assignment) {
        assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("Assignment not found with id " + id));

        Assignment updatedAssignment = assignmentMapper.toEntity(assignment);
        updatedAssignment.setId(id);
        Assignment savedAssigment = assignmentRepository.save(updatedAssignment);
        return assignmentMapper.toResponse(savedAssigment);
    }

    @Override
    public boolean deleteAssigment(Long id) {
        return false;
    }
}
