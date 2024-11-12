package org.demo.academicsystem.dto.authentication;

public record AuthenticationResponse(
        String fullName,
        String username,
        String email
) {
}
