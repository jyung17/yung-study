package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixdiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepsitory;

public class OrderServiceImpl implements OrderService {
  
  private final MemberRepository memberRepository = new MemoryMemberRepsitory();
  private final DiscountPolicy discountPolicy = new FixdiscountPolicy();
  
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
