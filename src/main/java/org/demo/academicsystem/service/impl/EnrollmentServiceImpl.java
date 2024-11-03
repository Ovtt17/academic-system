package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.enrollment.EnrollmentRequest;
import org.demo.academicsystem.dto.enrollment.EnrollmentResponse;
import org.demo.academicsystem.entity.Enrollment;
import org.demo.academicsystem.handler.exception.EnrollmentNotFoundException;
import org.demo.academicsystem.mapper.EnrollmentMapper;
import org.demo.academicsystem.repository.EnrollmentRepository;
import org.demo.academicsystem.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentResponse> getAll() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream()
                .map(enrollmentMapper::toResponse)
                .toList();
    }

    @Override
    public EnrollmentResponse getById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(
                () -> new EnrollmentNotFoundException("Enrollment not found with id " + id)
        );
        return enrollmentMapper.toResponse(enrollment);
    }

    @Override
    public EnrollmentResponse create(EnrollmentRequest enrollmentRequest) {
        Enrollment newEnrollment = enrollmentMapper.toEntity(enrollmentRequest);
        Enrollment savedEnrollment = enrollmentRepository.save(newEnrollment);
        return enrollmentMapper.toResponse(savedEnrollment);
    }

    @Override
    public EnrollmentResponse update(Long id, EnrollmentRequest enrollmentRequest) {
        enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found with id " + id));
        Enrollment updatedEnrollment = enrollmentMapper.toEntity(enrollmentRequest);
        updatedEnrollment.setId(id);
        Enrollment savedEnrollment = enrollmentRepository.save(updatedEnrollment);
        return enrollmentMapper.toResponse(savedEnrollment);
    }

    @Override
    public void delete(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException("Enrollment not found with id " + id);
        }
        enrollmentRepository.deleteById(id);
    }
}
