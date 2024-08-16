package com.allmytour.ai.app.mock;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
public class UserRole {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name="user_id" ,nullable = false )
    private User user;
    @JoinColumn(name="role_id" , nullable = false )
    private Role role;


    // 추가적인 속성 (예: 생성일, 상태 등)
    private LocalDateTime createdDate;


}
