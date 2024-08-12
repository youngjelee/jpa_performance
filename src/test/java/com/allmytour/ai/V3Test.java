package com.allmytour.ai;

import com.allmytour.ai.app.mock.v3.dto.ItemDto;
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



}
