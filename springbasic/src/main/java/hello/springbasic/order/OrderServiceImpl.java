package hello.springbasic.order;

import hello.springbasic.annotation.MainDiscountPolicy;
import hello.springbasic.discount.DiscountPolicy;
import hello.springbasic.discount.FixDiscountPolicy;
import hello.springbasic.discount.RateDiscountPolicy;
import hello.springbasic.member.Member;
import hello.springbasic.member.MemberRepository;
import hello.springbasic.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // OrderServiceImpl이 DiscountPolicy 인터페이스 뿐만 아니라 FixDiscountPolicy인 구체 클래스도 함께 의존하고 있다.
    // => DIP 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 인터페이스에만 의존
    private final DiscountPolicy discountPolicy;

    // 어떤 구현 객체가 주입될지 알 수 없다.
    // 오직 외부에서 결정
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
