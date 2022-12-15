package hello.springbasic.discount;

import hello.springbasic.annotation.MainDiscountPolicy;
import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Primary // 기본값
// Qualifier > Primary
// ex) 메인 DB 커넥션은 primary로 해놓고 서브 DB 커넥션은 Qualifier로 지정해서 사용
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        else
            return 0;
    }
}
