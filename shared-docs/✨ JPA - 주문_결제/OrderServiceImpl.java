package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.KakaoPayDto;
import com.springboot.shoppy_fullstack_app.entity.Order;
import com.springboot.shoppy_fullstack_app.jpa_repository.JpaCartRepository;
import com.springboot.shoppy_fullstack_app.jpa_repository.JpaOrderRepository;
import com.springboot.shoppy_fullstack_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private JpaOrderRepository jpaOrderRepository;
    private JpaCartRepository jpaCartRepository;

    @Autowired
    public OrderServiceImpl(JpaOrderRepository jpaOrderRepository,
                            JpaCartRepository jpaCartRepository){
        this.jpaOrderRepository = jpaOrderRepository;
        this.jpaCartRepository = jpaCartRepository;
    }

    @Override
//    @Transactional  //DB연동로직을 하나의 트랜잭션으로 관리
    public int save(KakaoPayDto kakaoPay) {
        System.out.println("kakaoPay == save ------------->> " + kakaoPay);
        /*** 👌 Step: 1 주문/결제 - 주문 테이블 저장    */
        Order entity = jpaOrderRepository.save(new Order(kakaoPay));
        if(entity == null) System.out.println("결제 실패!!");


        /*** 👌 Step: 2 주문/결제 - 주문 상세 테이블 저장    */
        String orderCode = kakaoPay.getOrderId();
        Integer discount = kakaoPay.getPaymentInfo().getDiscountAmount();
        List<Integer> cidList = kakaoPay.getCidList();
        int rows_detail = jpaOrderRepository.saveOrderDetail(orderCode, discount, cidList);
        if(!(rows_detail < 1)) System.out.println("결제 실패!!");

        /*** 👌 Step: 3 주문/결제 - 장바구니 삭제    */
        int delete_rows = jpaCartRepository.deleteCartItem(kakaoPay.getCidList());

        return 1;
    }

}
