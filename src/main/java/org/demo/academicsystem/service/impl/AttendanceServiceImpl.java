package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.attendance.AttendanceRequest;
import org.demo.academicsystem.dto.attendance.AttendanceResponse;
import org.demo.academicsystem.entity.Attendance;
import org.demo.academicsystem.handler.exception.AttendanceNotFoundException;
import org.demo.academicsystem.mapper.AttendanceMapper;
import org.demo.academicsystem.repository.AttendanceRepository;
import org.demo.academicsystem.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    public List<AttendanceResponse> getAll() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream()
                .map(attendanceMapper::toResponse)
                .toList();
    }

    @Override
    public AttendanceResponse getById(Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(
                () -> new AttendanceNotFoundException("Attendance not found with id " + id)
        );
        return attendanceMapper.toResponse(attendance);
    }

    @Override
    public AttendanceResponse create(AttendanceRequest attendanceRequest) {
        Attendance newAttendance = attendanceMapper.toEntity(attendanceRequest);
        Attendance savedAttendance = attendanceRepository.save(newAttendance);
        return attendanceMapper.toResponse(savedAttendance);
    }

    @Override
    public AttendanceResponse update(Long id, AttendanceRequest attendanceRequest) {
        attendanceRepository.findById(id)
                .orElseThrow(() -> new AttendanceNotFoundException("Attendance not found with id " + id));
        Attendance updatedAttendance = attendanceMapper.toEntity(attendanceRequest);
        updatedAttendance.setId(id);
        Attendance savedAttendance = attendanceRepository.save(updatedAttendance);
        return attendanceMapper.toResponse(savedAttendance);
    }

    @Override
    public void delete(Long aLong) {
        if (!attendanceRepository.existsById(aLong)) {
            throw new AttendanceNotFoundException("Attendance not found with id " + aLong);
        }
        attendanceRepository.deleteById(aLong);
    }
}
