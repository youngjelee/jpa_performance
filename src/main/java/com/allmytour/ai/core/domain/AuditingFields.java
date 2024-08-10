package com.allmytour.ai.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditingFields {

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "created_date")
    private LocalDateTime createdDate; //yyyy-mm-dd hh:mm:ss
//    @CreatedBy
//    @Column(nullable = false, updatable = false, name = "create_member_id") //TODO : 개발 완료 후 주석 해제
//    @Column(name = "create_member_id")
//    private Long createMemberId;
//    @Basic(fetch = FetchType.LAZY)
//    @Formula("(select a.member_name from member a where a.member_id = create_member_id)")
//    private String createMemberName;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate; //yyyy-mm-dd hh:mm:ss
//    @LastModifiedBy
//    @Column(name = "update_member_id")
//    private Long updateMemberId;
//    @Basic(fetch = FetchType.LAZY)
//    @Formula("(select a.member_name from member a where a.member_id = update_member_id)")
//    private String updateMemberName;

}

