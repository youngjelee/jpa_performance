package com.allmytour.ai.app.gpt.domain;

import com.allmytour.ai.core.domain.AuditingFields;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gpt_id")
    private Long id;

    private String requestContents;

    private String responseContents;

}
