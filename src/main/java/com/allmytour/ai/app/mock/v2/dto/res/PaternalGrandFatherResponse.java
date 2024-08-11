package com.allmytour.ai.app.mock.v2.dto.res;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.Father;
import com.allmytour.ai.app.mock.v2.entity.PaternalGrandFather;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PaternalGrandFatherResponse {

    private Long paternalId;
    private String paternalName;

    private List<FatherResponse> fatherResponse = new ArrayList<>();

    public PaternalGrandFatherResponse (PaternalGrandFather p ) {
        this.paternalId = p.getId();
        this.paternalName = p.getName();
        this.fatherResponse = p.getFathers().stream().map( FatherResponse::new ).collect(Collectors.toList());
    }
    @Data
    public static class FatherResponse{
        private Long fatherId;
        private String fatherName;

        private List<BabyResponse> babyResponses = new ArrayList<>() ;

        public FatherResponse(Father f ) {
            this.fatherId = f.getId();
            this.fatherName = f.getName();
            this.babyResponses =f.getBabyList().stream().map( BabyResponse::new).collect(Collectors.toList());
        }
    }

    @Data
    public static class BabyResponse{
        private Long babyId;
        private String babyName;

        public BabyResponse (Baby b ) {
            this.babyId = b.getId();
            this.babyName = b.getName();

        }
    }
}
