package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.grade.GradeRequest;
import org.demo.academicsystem.dto.grade.GradeResponse;
import org.demo.academicsystem.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
@Tag(name = "Grades")
public class GradeController {
    private final GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<GradeResponse>> getAllGrades() {
        return ResponseEntity.ok(gradeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeResponse> getGradeById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(gradeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<GradeResponse> createGrade(@RequestBody @Valid GradeRequest grade) {
        return ResponseEntity.ok(gradeService.create(grade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeResponse> updateGrade(
            @PathVariable @Valid Long id,
            @RequestBody @Valid GradeRequest grade
    ) {
        return ResponseEntity.ok(gradeService.update(id, grade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable @Valid Long id) {
        gradeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
