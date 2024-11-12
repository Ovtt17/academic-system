package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.authentication.AuthenticationResponse;
import org.demo.academicsystem.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/info")
    public ResponseEntity<AuthenticationResponse> getUserInfo(OAuth2AuthenticationToken authenticationToken) {
        return ResponseEntity.ok(authenticationService.getUserInfo(authenticationToken));
    }
}
