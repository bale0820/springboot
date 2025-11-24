package com.springboot.shoppy_fullstack_app.jpa_repository;

import com.springboot.shoppy_fullstack_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Integer> {
    /*** 👌 Step: 1 주문/결제 - 주문 테이블 저장    */
    Order save(Order order);

    /*** 👌 Step: 2 주문/결제 - 주문 상세 테이블 저장    */
    @Modifying
    @Query(value = """
            INSERT INTO 
                order_detail(order_code, pid, pname, size, qty, pid_total_price, discount)
            SELECT 
                :orderCode, pid, name AS pname, size, qty, total_price AS pid_total_price, 
                :discount
            FROM view_cartlist
            WHERE cid IN (:cidList)
            """, nativeQuery = true)
    int saveOrderDetail(@Param("orderCode") String orderCode,
                          @Param("discount") Integer discountAmount,
                          @Param("cidList") List<Integer> cidList);



}
