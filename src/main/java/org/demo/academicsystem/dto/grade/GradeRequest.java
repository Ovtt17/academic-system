package org.demo.academicsystem.dto.grade;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GradeRequest(
        @NotNull(message = "Grade is mandatory")
        @Size(max = 100, message = "Grade must be between 0 and 100")
        Double grade,

        @Size(max = 100, message = "Comments must be less than 100 characters")
        String comments,

        @NotNull(message = "Assignment ID is mandatory")
        Long assignmentId,

        @NotNull(message = "Course ID is mandatory")
        Long courseId,

        @NotNull(message = "Student ID is mandatory")
        Long studentId,

        @NotNull(message = "Teacher ID is mandatory")
        Long teacherId
) {
}
