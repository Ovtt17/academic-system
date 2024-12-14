package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.course.CourseRequest;
import org.demo.academicsystem.dto.course.CourseResponse;

import java.util.List;

public interface CourseService extends GenericService<CourseRequest, CourseResponse, Long> {
    List<CourseResponse> getAllTeacherCourses(String teacherUsername);
}
