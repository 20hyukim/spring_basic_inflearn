package hello.core.member;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//메모리에만 저장하기 위한 용도
@Component
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 concurrentHashMap 사용해야 함.
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
