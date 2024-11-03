package org.demo.academicsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.assignment.AssignmentRequest;
import org.demo.academicsystem.dto.assignment.AssignmentResponse;
import org.demo.academicsystem.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
@Tag(name = "Assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<List<AssignmentResponse>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentResponse> getAssignmentById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(assignmentService.getAssignmentById(id));
    }

    @PostMapping
    public ResponseEntity<AssignmentResponse> createAssignment(@RequestBody @Valid AssignmentRequest assignment) {
        return ResponseEntity.ok(assignmentService.createAssignment(assignment));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable @Valid Long id,
            @RequestBody @Valid AssignmentRequest assignment
    ) {
        return ResponseEntity.ok(assignmentService.updateAssignment(id, assignment));
    }
}
