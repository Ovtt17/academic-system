package org.demo.academicsystem.dto.dashboard;

import lombok.Builder;

@Builder
public record TopStudent(
        Long id,
        String fullName,
        Double average
) {
}
