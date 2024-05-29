package shopping.core.member;

public interface MemberRepository {
    //1.회원가입(등록)
    void save(Member member);

    //2.회원조회(검색)
    Member findById(Long memberId);
}
