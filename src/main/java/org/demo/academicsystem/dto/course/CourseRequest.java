package org.demo.academicsystem.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.demo.academicsystem.dto.courseSchedule.CourseScheduleRequest;

import java.util.List;

public record CourseRequest(
        @NotBlank(message = "Course name is required")
        @Size(min = 3, max = 50, message = "Course name must be between 3 and 50 characters")
        String name,

        @NotBlank(message = "Course description is required")
        @Size(min = 10, max = 150, message = "Course description must be between 10 and 150 characters")
        String description,

        @NotBlank(message = "Course section is required")
        @Size(min = 1, max = 50, message = "Course section must be between 1 and 50 characters")
        String section,

        @NotBlank(message = "Course semester is required")
        @Size(min = 3, max = 20, message = "Course semester must be between 3 and 20 characters")
        String semester,

        @NotNull(message = "Course schedule is required")
        List<CourseScheduleRequest> schedules
) {
}
