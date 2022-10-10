package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixdiscountPolicy;
import hello.core.discount.RateDiscountPoliy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepsitory;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 애플리케이션의 설정정보
// @Configuration을 클래스에 적용하고 @Bean을 해당 Class의 method에 적용하면 @Autowired로 Bean을 부를 수 있다.
// 스프링 컨테이너를 사용하면 어떤 장점이 있을까?
// -> 엔터프라이즈 개발을 하다보면 여기서 끝나는게아니다 할게 엄청많다.
// -> 스프링컨테이너를 사용하면 이점이 어마어마하게 많다.
public class AppConfig {
  
  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }
  
  @Bean
  public static MemoryMemberRepsitory memberRepository() {
    return new MemoryMemberRepsitory();
  }
  
  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }
  
  @Bean
  public DiscountPolicy discountPolicy() {
    //return new FixDiscountPoliy();
    return new RateDiscountPoliy();
  }
}
