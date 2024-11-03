package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.grade.GradeRequest;
import org.demo.academicsystem.dto.grade.GradeResponse;
import org.demo.academicsystem.entity.Grade;
import org.demo.academicsystem.handler.exception.GradeNotFoundException;
import org.demo.academicsystem.mapper.GradeMapper;
import org.demo.academicsystem.repository.GradeRepository;
import org.demo.academicsystem.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;

    @Override
    public List<GradeResponse> getAll() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream()
                .map(gradeMapper::toResponse)
                .toList();
    }

    @Override
    public GradeResponse getById(Long id) {
        Grade grade = gradeRepository.findById(id).orElseThrow(
                () -> new GradeNotFoundException("Grade not found with id " + id)
        );
        return gradeMapper.toResponse(grade);
    }

    @Override
    public GradeResponse create(GradeRequest gradeRequest) {
        Grade newGrade = gradeMapper.toEntity(gradeRequest);
        Grade savedGrade = gradeRepository.save(newGrade);
        return gradeMapper.toResponse(savedGrade);
    }

    @Override
    public GradeResponse update(Long id, GradeRequest gradeRequest) {
        gradeRepository.findById(id)
                .orElseThrow(() -> new GradeNotFoundException("Grade not found with id " + id));
        Grade updatedGrade = gradeMapper.toEntity(gradeRequest);
        updatedGrade.setId(id);
        Grade savedGrade = gradeRepository.save(updatedGrade);
        return gradeMapper.toResponse(savedGrade);
    }

    @Override
    public void delete(Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new GradeNotFoundException("Grade not found with id " + id);
        }
        gradeRepository.deleteById(id);
    }
}
