package org.demo.academicsystem.dto.dashboard;

import lombok.Builder;

@Builder
public record TeacherCourseDetails(Long id, String name, String description) {}
