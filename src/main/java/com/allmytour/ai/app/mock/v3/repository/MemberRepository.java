package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.Item;
import com.allmytour.ai.app.mock.v3.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
