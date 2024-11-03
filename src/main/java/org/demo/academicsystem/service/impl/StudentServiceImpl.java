package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.mapper.StudentMapper;
import org.demo.academicsystem.repository.StudentRepository;
import org.demo.academicsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponse> getAll() {
        return List.of();
    }

    @Override
    public StudentResponse getById(Long aLong) {
        return null;
    }

    @Override
    public StudentResponse create(StudentRequest studentRequest) {
        return null;
    }

    @Override
    public StudentResponse update(Long aLong, StudentRequest studentRequest) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
