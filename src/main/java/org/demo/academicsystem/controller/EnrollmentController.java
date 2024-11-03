package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.enrollment.EnrollmentRequest;
import org.demo.academicsystem.dto.enrollment.EnrollmentResponse;
import org.demo.academicsystem.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
@Tag(name = "Enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> createEnrollment(@RequestBody @Valid EnrollmentRequest enrollment) {
        return ResponseEntity.ok(enrollmentService.create(enrollment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(
            @PathVariable @Valid Long id,
            @RequestBody @Valid EnrollmentRequest enrollment
    ) {
        return ResponseEntity.ok(enrollmentService.update(id, enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable @Valid Long id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
