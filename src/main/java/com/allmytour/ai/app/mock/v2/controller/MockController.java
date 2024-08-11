package com.allmytour.ai.app.mock.v2.controller;

import com.allmytour.ai.app.mock.v2.dto.res.PaternalGrandFatherResponse;
import com.allmytour.ai.app.mock.v2.entity.Baby;
import com.allmytour.ai.app.mock.v2.entity.Father;
import com.allmytour.ai.app.mock.v2.entity.PaternalGrandFather;
import com.allmytour.ai.app.mock.v2.repository.BabyRepository;
import com.allmytour.ai.app.mock.v2.repository.FatherRepository;
import com.allmytour.ai.app.mock.v2.service.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mock/v2")
@RequiredArgsConstructor
public class MockController {

    private final BabyRepository babyRepository;
    private final FatherRepository fatherRepository;
    private final MockService mockService;

    @GetMapping("/babyAll")
    public String getAll(){
        List<Baby> babyList =  babyRepository.findAll();
        return babyList.toString();
    }

    @GetMapping("/baby/{id}")
    public String getBaby(@PathVariable("id") Long id) throws Exception {
        Baby baby =  babyRepository.findById( id ).orElseThrow( () ->  new Exception("없는 baby 입니다"));
        return baby.toString();
    }

    @GetMapping("/father/{id}")
    public String getFather(@PathVariable("id") Long id) throws Exception {
        Father father =  fatherRepository.findById( id ).orElseThrow( () ->  new Exception("없는 baby 입니다"));
        return father.toString();
    }

    // [TYPE:1] Specification을 이용한 방법
    @GetMapping("/getBabyCondition-v1")
    public Page<Baby> getBabiesByCondition_v1(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String fatherName,
            @RequestParam(required = false) String motherName,
            @PageableDefault(size=5 , page= 0 ) Pageable pageable) {

        return mockService.getBabyByCondition_v1(name, fatherName, motherName, pageable);
    }

    // [TYPE:2] Querydsl을 이용한 방법
    @GetMapping("/getBabyCondition-v2")
    public Page<Baby> getBabiesByCondition_v2(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String fatherName,
            @RequestParam(required = false) String motherName,
            @PageableDefault(size=5 , page= 0 ) Pageable pageable) {

        return mockService.getBabyByCondition_v2(name, fatherName, motherName, pageable);
    }
    // [TYPE:2] Querydsl을 최적화하는 방법
    @GetMapping("/getBabyCondition-v3")
    public Page<Baby> getBabiesByCondition_v3(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String fatherName,
            @RequestParam(required = false) String motherName,
            @PageableDefault(size=5 , page= 0 ) Pageable pageable) {

        return mockService.getBabyByCondition_v3(name, fatherName, motherName, pageable);
    }

    @GetMapping("/getFather-v1/{id}")
    public Father getFather_v1(@PathVariable("id") Long id ) throws Exception{
        Father f = mockService.getFatherById_v1(id);
        return f;
    }

    @GetMapping("/getFather-v2/{id}")
    public Father getFather_v2(@PathVariable("id") Long id ) throws Exception{
        Father f = mockService.getFatherById_v2(id);
        return f;
    }

    @GetMapping("/getPaternalGrandFather/{id}")
    public PaternalGrandFather getPaternalGrandFather(@PathVariable("id") Long id ) throws Exception{
        PaternalGrandFather f = mockService.getPaternalGrandFather(id);


        return f;
    }

    @GetMapping("/getPaternalGrandFather-v2/{id}")
    public PaternalGrandFatherResponse getPaternalGrandFather_v2(@PathVariable("id") Long id ) throws Exception{
        PaternalGrandFatherResponse f = mockService.getPaternalGrandFather_v2(id);


        return f;
    }


}
