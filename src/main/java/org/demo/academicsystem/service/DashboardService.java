package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.dashboard.DashboardData;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface DashboardService {
    DashboardData getDashboardData(OAuth2AuthenticationToken teacherId);
}
