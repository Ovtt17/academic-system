package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.attendance.AttendanceRequest;
import org.demo.academicsystem.dto.attendance.AttendanceResponse;
import org.demo.academicsystem.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
@Tag(name = "Attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<List<AttendanceResponse>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponse> getAttendanceById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok(attendanceService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AttendanceResponse> createAttendance(@RequestBody @Valid AttendanceRequest attendance) {
        return ResponseEntity.ok(attendanceService.create(attendance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponse> updateAttendance(
            @PathVariable @Valid Long id,
            @RequestBody @Valid AttendanceRequest attendance
    ) {
        return ResponseEntity.ok(attendanceService.update(id, attendance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable @Valid Long id) {
        attendanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
