package kr.idu.OInjo_Shop.repository.Order;

import kr.idu.OInjo_Shop.entity.Order.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select  o from OrderEntity o " +
            "where o.member.memberEmail = :email " +
            "order by o.orderDate desc"
    )
    List<OrderEntity> findOrders(@Param("email") String email, Pageable pageable);

    @Query("select count(o) from OrderEntity o " +
            "where o.member.memberEmail = :email"
    )
    Long totalOrder(@Param("email") String email);
}
