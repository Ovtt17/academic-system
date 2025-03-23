package org.demo.academicsystem.dto.authentication;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String fullName,
        String username,
        String email,
        String profilePicture
) {
}
