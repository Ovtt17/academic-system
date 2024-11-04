package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.dashboard.TopStudent;
import org.demo.academicsystem.dto.student.StudentRequest;
import org.demo.academicsystem.dto.student.StudentResponse;

import java.util.List;

public interface StudentService extends GenericService<StudentRequest, StudentResponse, Long> {
    List<TopStudent> getTop10Students(Long teacherId);
}
