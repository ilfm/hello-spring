package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;      // 회원ID 시퀀스

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        // 시퀀스로 member 객체 저장
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findId(Long id) {
        
        return Optional.ofNullable(store.get(id));
        // !!! Optional 추후 보강
    }

    @Override
    public Optional<Member> findName(String name) {
        // !!! 람다식 분석 해볼것
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // !!! 람다식 분석 해볼것
        return new ArrayList<>(store.values());
    }
}
