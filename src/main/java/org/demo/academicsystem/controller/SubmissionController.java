package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.submission.SubmissionRequest;
import org.demo.academicsystem.dto.submission.SubmissionResponse;
import org.demo.academicsystem.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
@RequiredArgsConstructor
@Tag(name = "Submissions")
public class SubmissionController {
    private final SubmissionService submissionService;

    @GetMapping
    public ResponseEntity<List<SubmissionResponse>> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmissionResponse> getSubmissionById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(submissionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SubmissionResponse> createSubmission(@RequestBody @Valid SubmissionRequest submission) {
        return ResponseEntity.ok(submissionService.create(submission));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubmissionResponse> updateSubmission(
            @PathVariable @Valid Long id,
            @RequestBody @Valid SubmissionRequest submission
    ) {
        return ResponseEntity.ok(submissionService.update(id, submission));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable @Valid Long id) {
        submissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
