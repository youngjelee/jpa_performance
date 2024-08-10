package com.allmytour.ai.app.mock.v2.service;

import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.repository.BabyRepository;
import com.allmytour.ai.app.mock.v2.specification.BabySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockService {

    private final BabyRepository babyRepository;

    // [TYPE:1 ]  Specitfication 이용한방법
    public Page<Baby> getBabyByCondition_v1(String name, String fatherName, String motherName,  Pageable pageable) {
        Specification<Baby> spec =
                Specification
                        .where(BabySpecification.hasName(name))
                        .and(BabySpecification.hasFatherName(fatherName))
                        .and(BabySpecification.hasMotherName(motherName));

        Page<Baby> babyPage = babyRepository.findAll(spec, pageable);

        return babyPage;
    }


    // [TYPE:2 ]  queryDsl 를이용한 방법
    public Page<Baby> getBabyByCondition_v2(String name, String fatherName, String motherName,  Pageable pageable){
        Page<Baby> babyPage = babyRepository.findBabiesByQueryDsl( name, fatherName,  motherName,   pageable );
        return babyPage;
    }


    // [TYPE:2 ]  queryDsl 를 최적화하는 방법
    public Page<Baby> getBabyByCondition_v3(String name, String fatherName, String motherName,  Pageable pageable){
        Page<Baby> babyPage = babyRepository.findBabiesByQueryDsl2( name, fatherName,  motherName,   pageable );
        return babyPage;
    }
}
