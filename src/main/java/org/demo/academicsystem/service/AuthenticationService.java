package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.authentication.AuthenticationResponse;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface AuthenticationService {
    AuthenticationResponse getUserInfo(OAuth2AuthenticationToken authenticationToken);
}
