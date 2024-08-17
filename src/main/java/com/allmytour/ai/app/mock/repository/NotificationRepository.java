package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.Notification;
import com.allmytour.ai.app.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
