package shopping.core.discount;

import shopping.core.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인된 금액을 리턴
     */
    int discount(Member member, int price);
}
