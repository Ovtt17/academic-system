package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;
import org.demo.academicsystem.entity.Student;
import org.demo.academicsystem.handler.exception.StudentNotFoundException;
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
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException("Student not found with id " + id)
        );
        return studentMapper.toResponse(student);
    }

    @Override
    public StudentResponse create(StudentRequest studentRequest) {
        Student newStudent = studentMapper.toEntity(studentRequest);
        Student savedStudent = studentRepository.save(newStudent);
        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        Student updatedStudent = studentMapper.toEntity(studentRequest);
        updatedStudent.setId(id);
        Student savedStudent = studentRepository.save(updatedStudent);
        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentResponse> getTop10Students(Long teacherId) {
        List<Student> students = studentRepository.findTop10StudentsByTeacherIdOrderByAverageGradeDesc(teacherId);
        return students.stream()
                .map(studentMapper::toResponse)
                .toList();
    }
}
