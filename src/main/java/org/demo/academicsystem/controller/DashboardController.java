package org.demo.academicsystem.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.dashboard.DashboardData;
import org.demo.academicsystem.service.DashboardService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@Tag(name = "Dashboard", description = "Dashboard API")
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping
    public DashboardData getDashboardData(OAuth2AuthenticationToken authenticationToken) {
        return dashboardService.getDashboardData(authenticationToken);
    }
}
