package com.allmytour.ai.app.mock.v1.controller;

import com.allmytour.ai.app.mock.v1.domain.Child;
import com.allmytour.ai.app.mock.v1.domain.GrandParent;
import com.allmytour.ai.app.mock.v1.domain.Parent;
import com.allmytour.ai.app.mock.v1.dto.SearchCriteria;
import com.allmytour.ai.app.mock.v1.service.EtcService;
import com.allmytour.ai.core.common.ApiResponse;
import com.allmytour.ai.core.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etc")
public class EtcController {

    private final EtcService etcService;

    @GetMapping("/makeGrandParent")
    public void makeGrandParent(String num){
        System.out.println(num);
        GrandParent gp = etcService.makeGrandParent(num );
        System.out.println(gp);
    }
    @GetMapping("/randomMakeParent")
    public void randomMakeParent(String num ){
        etcService.randomMakeParent( num );
    }
    @GetMapping("/makeGrandParentParent")
    public void makeGrandParentParent(String num){
        etcService.makeGrandParentParent(num);
    }
    @GetMapping("/findParentsByCriteria")
    public ApiResponse<?> findParentsByCriteria ( @ModelAttribute SearchCriteria searchCriteria) {

        List<Parent> parentList = etcService.findParentsByCriteria(searchCriteria);

        return ApiResponse.success(ResponseCode.SUCCESS , parentList );
    }

    @GetMapping("/findChildByCriteria")
    public ApiResponse<?> findChildByCriteria ( @ModelAttribute SearchCriteria searchCriteria) {

        List<Child> childList = etcService.findChildByCriteria(searchCriteria);

        return ApiResponse.success(ResponseCode.SUCCESS , childList );
    }

    @GetMapping("/makeGrandChild")
    public void makeGrandChild(){

    }
    @GetMapping("/makeChild")
    public void makeChild(){

    }

    @GetMapping("/getGrandParent")
    public String getGrandParent(Long id){
        etcService.getGrandParent(id);
        return "";
    }
}
