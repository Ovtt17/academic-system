package org.demo.academicsystem.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Tag(name = "Courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody @Valid CourseRequest course) {
        return ResponseEntity.ok(courseService.create(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> updateCourse(
            @PathVariable @Valid Long id,
            @RequestBody @Valid CourseRequest course
    ) {
        return ResponseEntity.ok(courseService.update(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable @Valid Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
