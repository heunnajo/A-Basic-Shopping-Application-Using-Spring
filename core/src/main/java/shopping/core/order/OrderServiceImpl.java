package shopping.core.order;

import shopping.core.discount.DiscountPolicy;
import shopping.core.discount.FixDiscountPolicy;
import shopping.core.discount.RateDiscountPolicy;
import shopping.core.member.Member;
import shopping.core.member.MemberRepository;
import shopping.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy2 = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice ) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인에 대해서는 discountPolicy 에 위임하고 리턴값만 받는다 : 단일 책임 원칙을 지켜서 설계를 잘 했다!
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

}
