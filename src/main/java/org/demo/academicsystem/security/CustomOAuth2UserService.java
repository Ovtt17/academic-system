package org.demo.academicsystem.security;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.entity.Teacher;
import org.demo.academicsystem.repository.TeacherRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final TeacherRepository teacherRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        Teacher existingTeacher = teacherRepository.findByEmail(email);
        if (existingTeacher == null) {
            Teacher newTeacher = Teacher.builder()
                    .email(email)
                    .firstName(oAuth2User.getAttribute("given_name"))
                    .lastName(oAuth2User.getAttribute("family_name"))
                    .profilePicture(oAuth2User.getAttribute("picture"))
                    .username(email)
                    .password("default_password")
                    .build();
            teacherRepository.save(newTeacher);

        }
        return oAuth2User;
    }
}
