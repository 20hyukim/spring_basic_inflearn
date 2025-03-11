package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//application 의 설정 정보를 담당
@Configuration
public class AppConfig {
    // 구현과 역할이 명확하게 보인다.

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 싱글톤이 적용이 될까?

    // 1. memberService 호출
    //call AppConfig.memberService
    //call AppConfig.memberRepository

    // 2. repository 호출
    //call AppConfig.memberRepository

    // 3. orderService 호출
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    @Bean
    public MemberService memberService() { // 역할
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 구현
    }

    @Bean
    public MemberRepository memberRepository() { // 역할
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository(); // 구현
    }

    @Bean
    public OrderService orderService() { // 역할
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 구현
        //return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() { // 역할
        //return new FixDiscountPolicy(); // 구현
        return new RateDiscountPolicy();
    }
}
