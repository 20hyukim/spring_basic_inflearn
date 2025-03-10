package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 구현체를 생성 -> 추상화에만 의존
    private final MemberRepository memberRepository;

    @Autowired // 자동으로 의존관계 주입. memberRepository를 찾아와서, 주입해줌. // ac.getBean(MemberRepository.class) 와 같이 작동.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
