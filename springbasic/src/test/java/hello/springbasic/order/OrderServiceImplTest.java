package hello.springbasic.order;

import hello.springbasic.discount.FixDiscountPolicy;
import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import hello.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        // 수정자 주입시 의존관계 주입이 누락
//        OrderServiceImpl orderService = new OrderServiceImpl();


        // 생성자 주입시 컴파일 오류 생성
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}