package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;
import org.demo.academicsystem.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    @Override
    public List<CourseResponse> getAllCourses() {
        return List.of();
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        return null;
    }

    @Override
    public CourseResponse createCourse(CourseRequest course) {
        return null;
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
