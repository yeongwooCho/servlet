package yeongwoo.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    // singleton pattern 이라서 아래 두개 변수는 static으로 선언 안 해도 된다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store.values()는 store에 있는 모든 값들을 Collection<Member>로 반환한다.
        // 그리고 그 Collection<Member>를 ArrayList<Member>로 반환한다.
        // store 값 자체를 보호하기 위해 ArrayList로 반환한다.
        return new ArrayList<>(store.values());
    }

    public void cleanStore() {
        store.clear();
    }
}
