package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.authentication.AuthenticationResponse;
import org.demo.academicsystem.entity.Teacher;
import org.demo.academicsystem.service.AuthenticationService;
import org.demo.academicsystem.service.TeacherService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final TeacherService teacherService;

    @Override
    public AuthenticationResponse getUserInfo(OAuth2AuthenticationToken authenticationToken) {
        Map<String, Object> attributes = authenticationToken.getPrincipal().getAttributes();
        String email = (String) attributes.get("email");

        Teacher teacher = teacherService.getTeacherByEmail(email);

        return AuthenticationResponse.builder()
                .fullName(teacher.getFullName())
                .username(teacher.getUsername())
                .email(teacher.getEmail())
                .profilePicture(teacher.getProfilePicture())
                .build();
    }
}
