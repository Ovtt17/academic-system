package org.demo.academicsystem.service.impl;

import org.demo.academicsystem.dto.authentication.AuthenticationResponse;
import org.demo.academicsystem.service.AuthenticationService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public AuthenticationResponse getUserInfo(OAuth2AuthenticationToken authenticationToken) {
        Map<String, Object> attributes = authenticationToken.getPrincipal().getAttributes();
        String fullName = (String) attributes.get("name");
        String username = (String) attributes.get("preferred_username");
        String email = (String) attributes.get("email");
        return new AuthenticationResponse(fullName, username, email);
    }
}
