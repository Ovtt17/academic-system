package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.dto.dashboard.PendingAssignment;
import org.demo.academicsystem.entity.Assignment;
import org.demo.academicsystem.handler.exception.AssignmentNotFoundException;
import org.demo.academicsystem.mapper.AssignmentMapper;
import org.demo.academicsystem.repository.AssignmentRepository;
import org.demo.academicsystem.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper assignmentMapper;

    @Override
    public List<AssignmentResponse> getAll() {
        List<Assignment> assignments = assignmentRepository.findAll();
        return assignments.stream()
                .map(assignmentMapper::toResponse)
                .toList();
    }

    @Override
    public AssignmentResponse getById(Long id) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(
                () -> new AssignmentNotFoundException("Assignment not found with id " + id)
        );
        return assignmentMapper.toResponse(assignment);
    }

    @Override
    public AssignmentResponse create(AssignmentRequest assignmentRequest) {
        Assignment newAssigment = assignmentMapper.toEntity(assignmentRequest);
        Assignment savedAssigment = assignmentRepository.save(newAssigment);
        return assignmentMapper.toResponse(savedAssigment);
    }

    @Override
    public AssignmentResponse update(Long id, AssignmentRequest assignmentRequest) {
        assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("Assignment not found with id " + id));

        Assignment updatedAssignment = assignmentMapper.toEntity(assignmentRequest);
        updatedAssignment.setId(id);
        Assignment savedAssigment = assignmentRepository.save(updatedAssignment);
        return assignmentMapper.toResponse(savedAssigment);
    }

    @Override
    public void delete(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new AssignmentNotFoundException("Assignment not found with id " + id);
        }
        assignmentRepository.deleteById(id);
    }

    @Override
    public List<PendingAssignment> getPendingAssignments() {
        return assignmentRepository.findPendingAssignments(LocalDate.now());
    }
}
