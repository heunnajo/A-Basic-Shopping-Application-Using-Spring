package shopping.core;

import shopping.core.discount.DiscountPolicy;
import shopping.core.discount.FixDiscountPolicy;
import shopping.core.member.MemberService;
import shopping.core.member.MemberServiceImpl;
import shopping.core.member.MemoryMemberRepository;
import shopping.core.order.OrderService;
import shopping.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입 : 생성자를 통해 의존성 주입
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()); //생성자 주입 : 생성자를 통해 의존성 주입
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
