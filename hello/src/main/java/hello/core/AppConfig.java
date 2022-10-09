package hello.core;

import hello.core.discount.FixdiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepsitory;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
  
  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepsitory());
  }
  
  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepsitory(), new FixdiscountPolicy());
  }
}
