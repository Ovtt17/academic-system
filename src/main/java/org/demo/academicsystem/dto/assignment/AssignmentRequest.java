package org.demo.academicsystem.dto.assignment;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AssignmentRequest(
        Long id,

        @NotBlank(message = "Title is mandatory")
        @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
        String title,

        @NotBlank(message = "Description is mandatory")
        @Size(min = 3, max = 500, message = "Description must be between 3 and 500 characters")
        String description,

        @NotNull(message = "Due date is mandatory")
        @FutureOrPresent(message = "Due date must be in the future")
        LocalDate dueDate,

        @NotNull(message = "Course ID is mandatory")
        Long courseId
) {
}
