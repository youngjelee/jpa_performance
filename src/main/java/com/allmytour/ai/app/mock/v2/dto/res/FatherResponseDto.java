package com.allmytour.ai.app.mock.v2.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatherResponseDto {

    private Long fatherId;
    private String fatherName;

    private Long grandfaId;
    private String grandfaName;
//    private List<>

    private Long grandmaId;
    private String grandmaName;
}
