package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "Students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody @Valid StudentRequest student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable @Valid Long id,
            @RequestBody @Valid StudentRequest student
    ) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable @Valid Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
