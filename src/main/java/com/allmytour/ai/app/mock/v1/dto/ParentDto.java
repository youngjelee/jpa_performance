package com.allmytour.ai.app.mock.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentDto {

    private Long id ;
    private String name;
    private Long grandParentId;
    private String grandParentName;
}
