package org.demo.academicsystem.dto.grade;

import lombok.Builder;
import org.demo.academicsystem.dto.student.StudentResponse;

@Builder
public record GradeResponse(
        Long id,
        Double grade,
        String comments,
        StudentResponse student
) {
}
