package org.demo.academicsystem.mapper;

import org.demo.academicsystem.dto.attendance.AttendanceRequest;
import org.demo.academicsystem.dto.attendance.AttendanceResponse;
import org.demo.academicsystem.entity.Attendance;
import org.demo.academicsystem.entity.Course;
import org.demo.academicsystem.entity.CourseSchedule;
import org.demo.academicsystem.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {
    public Attendance toEntity(AttendanceRequest request) {
        Student student = Student.builder()
                .id(request.studentId())
                .build();

        Course course = Course.builder()
                .id(request.courseId())
                .build();

        CourseSchedule schedule = CourseSchedule.builder()
                .id(request.courseScheduleId())
                .build();

        return Attendance.builder()
                .student(student)
                .course(course)
                .schedule(schedule)
                .status(request.status())
                .build();
    }

    public AttendanceResponse toResponse(Attendance attendance) {
        return new AttendanceResponse(
                attendance.getId(),
                attendance.getStudent().getFullName(),
                attendance.getCourse().getName(),
                attendance.getCreatedDate(),
                attendance.getStatus()
        );
    }
}
