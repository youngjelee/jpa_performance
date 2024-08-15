package com.allmytour.ai.app.mock.v3.repository;

import com.allmytour.ai.app.mock.v3.entity.Test2;

import java.util.List;

public interface Test2RepositoryCustom {


    List<Test2> getData(String name ) ;

    List<Test2> getFetchJoinData(String name) ;

    List<Test2> getFetchJoinDataFilterTest1(String name , Long id ) ;


}
