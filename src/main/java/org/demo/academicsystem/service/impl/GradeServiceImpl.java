package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.grade.GradeRequest;
import org.demo.academicsystem.dto.grade.GradeResponse;
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
        return List.of();
    }

    @Override
    public GradeResponse getById(Long aLong) {
        return null;
    }

    @Override
    public GradeResponse create(GradeRequest gradeRequest) {
        return null;
    }

    @Override
    public GradeResponse update(Long aLong, GradeRequest gradeRequest) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
