package com.allmytour.ai.app.poi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PoiRequestDto {

    @Schema(description = "개통 내역 PK")
    private Long productIdx;
    @Schema(description = "위도")
    private double lat;
    @Schema(description = "경도")
    private double lng;


}
