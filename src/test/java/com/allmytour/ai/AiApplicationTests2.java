package com.allmytour.ai;

import com.allmytour.ai.app.mock.v3.entity.Test1;
import com.allmytour.ai.app.mock.v3.entity.Test2;
import com.allmytour.ai.app.mock.v3.repository.*;
import com.allmytour.ai.app.mock.v3.service.TotalTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AiApplicationTests2 {

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

	@Autowired
	TotalTestService totalTestService;


	@Test
	public void test1( ) {

		List<Test1> testList = new ArrayList<>();
		for (int i = 1000 ;i < 10000 ;i ++ ) {
			Test1 t = new Test1();
			t.setName("test_"+i);
			testList.add(t);
		}
		test1Repository.saveAll(testList);

	}

	@Test
	public void test2( ) {

		List<Test2> testList = new ArrayList<>();
		for (int i = 1 ;i < 5000 ;i ++ ) {
			Test2 t = new Test2();
			t.setName("test__"+i);
			t.setTest1( test1Repository.findById((long) i).get() );
			testList.add(t);
		}
		test2Repository.saveAll(testList);

	}

	@Test
	public void test2_getOne(){

		try{
			Test2 t = test2Repository.findById(1L).get();
			System.out.print(t);
		}catch(Exception e ) {
			System.out.println("lazy load 로 인한 에러 발생나면 성공");
			e.printStackTrace();
		}

		Test2  t = totalTestService.getTest2ById( 1L ) ;
		System.out.print(t);

	}

	@Test
	public void test3List(){

		try{
			List<Test2> t = test2Repository.getData("test__1");
			System.out.print(t);
		}catch(Exception e ) {
			System.out.println("lazy load 로 인한 에러 발생나면 성공");
			e.printStackTrace();
		}
		// 해당부문은 fetchJoin 으로 실행
		List<Test2> t = test2Repository.getFetchJoinData("test__1") ;
		System.out.print(t);

	}

	@Test
	public void getFetchJoinDataFilterTest1(){


		// 해당부문은 fetchJoin 으로 실행
		List<Test2> t = test2Repository.getFetchJoinDataFilterTest1("test__1" , 500L) ;
		System.out.print(t);

	}

	@Test
	void contextLoads() {
	}

}
