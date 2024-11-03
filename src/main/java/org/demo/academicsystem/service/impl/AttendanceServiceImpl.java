package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.attendance.AttendanceRequest;
import org.demo.academicsystem.dto.attendance.AttendanceResponse;
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
        return List.of();
    }

    @Override
    public AttendanceResponse getById(Long aLong) {
        return null;
    }

    @Override
    public AttendanceResponse create(AttendanceRequest attendanceRequest) {
        return null;
    }

    @Override
    public AttendanceResponse update(Long aLong, AttendanceRequest attendanceRequest) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
