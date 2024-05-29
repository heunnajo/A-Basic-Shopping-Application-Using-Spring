package shopping.core.discount;

import shopping.core.member.Grade;
import shopping.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        //enum 타입의 비교는 ==
        if(member.getGrade() == Grade.VIP){
            return discountPercent / 100;
        } else{
            return 0;
        }
    }
}
