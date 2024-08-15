package com.allmytour.ai.app.mock.v3.service;

import com.allmytour.ai.app.mock.v3.entity.Test2;
import com.allmytour.ai.app.mock.v3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalTestService {

    @Autowired
    Test1Repository test1Repository;
    @Autowired
    Test2Repository test2Repository;
    @Autowired
    Test3Repository test3Repository;
    @Autowired
    Test4Repository test4Repository;
    @Autowired
    Test5Repository test5Repository;

    @Transactional
    public Test2 getTest2ById( Long id ) {

        Test2 t = test2Repository.findById(1L).get();
        t.getTest1();
        return t;
    }


}
