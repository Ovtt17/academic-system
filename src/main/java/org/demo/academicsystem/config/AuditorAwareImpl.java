package org.demo.academicsystem.config;

import org.demo.academicsystem.entity.Teacher;
import org.demo.academicsystem.service.TeacherService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<Teacher> {
    private final TeacherService teacherService;

    public AuditorAwareImpl(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    @NonNull
    public Optional<Teacher> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof DefaultOAuth2User oAuth2User) {
            String email = oAuth2User.getAttribute("email");
            if (email == null) {
                return Optional.empty();
            }
            Teacher teacher = teacherService.getTeacherByEmail(email);
            return Optional.of(teacher);
        }

        return Optional.empty();
    }
}