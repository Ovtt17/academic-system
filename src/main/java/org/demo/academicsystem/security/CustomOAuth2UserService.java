package org.demo.academicsystem.security;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.entity.Teacher;
import org.demo.academicsystem.repository.TeacherRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final TeacherRepository teacherRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String email = Objects.requireNonNull(oAuth2User.getAttribute("email")).toString();

        Optional<Teacher> existingTeacher = teacherRepository.findByEmail(email);
        Teacher teacher;

        if (existingTeacher.isEmpty()) {
            teacher = new Teacher();
            teacher.setFirstName(oAuth2User.getAttribute("given_name"));
            teacher.setLastName(oAuth2User.getAttribute("family_name"));
            teacher.setProvider(registrationId);
            teacher.setUsername(email.split("@")[0]);
            teacher.setEmail(email);
            teacher.setProfilePicture(oAuth2User.getAttribute("picture"));
            teacher.setDateOfJoining(LocalDate.now());
            teacherRepository.save(teacher);
        }

        return new DefaultOAuth2User(
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")),
                oAuth2User.getAttributes(),
                "name"
        );
    }
}