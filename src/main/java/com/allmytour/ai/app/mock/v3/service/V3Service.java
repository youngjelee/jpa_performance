package com.allmytour.ai.app.mock.v3.service;

import com.allmytour.ai.app.mock.v3.dto.ItemDto;
import com.allmytour.ai.app.mock.v3.entity.Item;
import com.allmytour.ai.app.mock.v3.entity.Member;
import com.allmytour.ai.app.mock.v3.entity.Order;
import com.allmytour.ai.app.mock.v3.entity.OrderItem;
import com.allmytour.ai.app.mock.v3.repository.ItemRepository;
import com.allmytour.ai.app.mock.v3.repository.MemberRepository;
import com.allmytour.ai.app.mock.v3.repository.OrderItemRepository;
import com.allmytour.ai.app.mock.v3.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class V3Service {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;



    public void makeOrder(Long memberId
                        , List<ItemDto> reqList)
    {

        Member m = memberRepository.findById(memberId).orElseThrow(()-> new RuntimeException("없는회원"));

        List<Item> itemList = itemRepository.findAllById(reqList.stream().map(ItemDto::getItemId).collect(Collectors.toList()));

        if( itemList== null ||  ( reqList.size() !=  itemList.size() ) ) throw new RuntimeException("상품 개수가 맞지않음") ;

        itemList.forEach( item-> {
            if( item.getCount() < 1 ) throw new RuntimeException( item.getName() +"상품 재고없음");
        });

        //주문생성
        Order order = Order.makeOrder( "orderName Test " , m  );
        orderRepository.save( order );
        List<OrderItem> orderItems = new ArrayList<>();
        //orderItem 생성
        for ( int i = 0 ; i < itemList.size() ; i++ ) {

            Item item =  itemList.get(i) ;
            if( reqList.get(i).getQuantity() > item.getCount()) throw new RuntimeException( item.getName() +" 은  요청한 개수가 재고보다 많습니다. " );

            OrderItem oi = OrderItem.makeOrderItem( order , itemList.get(i) , reqList.get(i ) ) ;
            orderItems.add(oi);

            item.minusStock( reqList.get(i).getQuantity() );

        }
        orderItemRepository.saveAll( orderItems ) ;

        itemRepository.saveAll(itemList) ;




    }

}
