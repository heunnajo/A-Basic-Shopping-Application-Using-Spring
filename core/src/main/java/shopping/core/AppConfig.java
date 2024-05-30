package shopping.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.core.discount.DiscountPolicy;
import shopping.core.discount.FixDiscountPolicy;
import shopping.core.discount.RateDiscountPolicy;
import shopping.core.member.MemberRepository;
import shopping.core.member.MemberService;
import shopping.core.member.MemberServiceImpl;
import shopping.core.member.MemoryMemberRepository;
import shopping.core.order.OrderService;
import shopping.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //생성자 주입 : 생성자를 통해 의존성 주입
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(); //생성자 주입 : 생성자를 통해 의존성 주입
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //생성자 주입 : 생성자를 통해 의존성 주입
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();

    }
}
