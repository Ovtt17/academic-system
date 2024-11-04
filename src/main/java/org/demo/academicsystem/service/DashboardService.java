package org.demo.academicsystem.service;

import org.demo.academicsystem.dto.dashboard.DashboardData;

public interface DashboardService {
    DashboardData getDashboardData(Long teacherId);
}
