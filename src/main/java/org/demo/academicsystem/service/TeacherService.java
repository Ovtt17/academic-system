package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.teacher.TeacherRequest;
import org.demo.academicsystem.dto.teacher.TeacherResponse;
import org.demo.academicsystem.entity.Teacher;

public interface TeacherService extends GenericService<TeacherRequest, TeacherResponse, Long> {
    Teacher getTeacherByEmail(String email);
}
