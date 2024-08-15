package com.allmytour.ai;

import com.allmytour.ai.app.mock.v3.dto.ItemDto;
import com.allmytour.ai.app.mock.v3.entity.JoinData;
import com.allmytour.ai.app.mock.v3.entity.NoForienTest;
import com.allmytour.ai.app.mock.v3.entity.Test1;
//import com.allmytour.ai.app.mock.v3.repository.NoForeienRepository;
import com.allmytour.ai.app.mock.v3.repository.NoForeienRepository;
import com.allmytour.ai.app.mock.v3.repository.Test1Repository;
import com.allmytour.ai.app.mock.v3.service.V3Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class V3Test {

    @Autowired
    V3Service v3Service;

    @Autowired
    Test1Repository test1Repository;

    @Autowired
    NoForeienRepository noForeienRepository;


    @Test
    public void getJoinData(){

        List<JoinData> list =
        noForeienRepository.getJoinData(100L , "noForigenTest_10");

        System.out.println(list);
    }



    @Test
    public void saveOrder(){

        List<ItemDto> orderList = new ArrayList<>();
        ItemDto itemDto1 = new ItemDto(1L , 3L );
        ItemDto itemDto2 = new ItemDto(2L , 3L );
        ItemDto itemDto3 = new ItemDto(3L , 3L );
        ItemDto itemDto4 = new ItemDto(5L , 3L );
        ItemDto itemDto5 = new ItemDto(6L , 3L );
        ItemDto itemDto6 = new ItemDto(16L , 3L );
        orderList.add(itemDto1) ;
        orderList.add(itemDto2) ;
        orderList.add(itemDto3) ;
        orderList.add(itemDto4) ;
        orderList.add(itemDto5) ;
        orderList.add(itemDto6) ;


        v3Service.makeOrder( 1L , orderList  );
        v3Service.makeOrder( 2L , orderList  );
        v3Service.makeOrder( 3L , orderList  );
        v3Service.makeOrder( 4L , orderList  );
        v3Service.makeOrder( 5L , orderList  );

    }

    @Test
    public void make1000NoFor() {

        List<NoForienTest> list = new ArrayList<>();

        for (int i = 1; i < 15000; i++) {
            Test1 t = test1Repository.findById((long) i).get();

            NoForienTest noForienTest = new NoForienTest();
            noForienTest.setName("noForigenTest_" + i);
            noForienTest.setTest1id(t.getId());
            list.add(noForienTest);
        }
        noForeienRepository.saveAll(list);

    }

    @Test
    public void test1(){
        System.out.print(11111);
    }




}
