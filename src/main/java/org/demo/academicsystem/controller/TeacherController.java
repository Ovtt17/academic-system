package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
@Tag(name = "Teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> createAssignment(@RequestBody @Valid TeacherRequest teacher) {
        return ResponseEntity.ok(teacherService.create(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateAssignment(
            @PathVariable @Valid Long id,
            @RequestBody @Valid TeacherRequest teacher
    ) {
        return ResponseEntity.ok(teacherService.update(id, teacher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable @Valid Long id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
