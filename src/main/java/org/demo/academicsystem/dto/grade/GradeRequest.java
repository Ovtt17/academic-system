package org.demo.academicsystem.dto.grade;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GradeRequest(
        @NotNull(message = "Grade is mandatory")
        @DecimalMin(value = "0.0", message = "Grade must be at least 0")
        @DecimalMax(value = "60.0", message = "Grade must be at most 60")
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
