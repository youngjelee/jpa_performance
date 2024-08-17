package com.allmytour.ai.app.mock.repository;

import com.allmytour.ai.app.mock.entity.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {
}
