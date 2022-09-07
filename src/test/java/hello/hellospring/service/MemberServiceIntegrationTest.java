package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 통합 테스트 : 스프링 컨테이너를 올려 테스트하겠다.
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    // Dependency Injection : DI

    @Test
    void join() {
        // given
        Member member = new Member("Joe", 21);
        // when
        Long id = memberService.join(member);
        member.setId(id);
        // then
        Member result = memberService.findOne(id).get();
        assertThat(result.getName()).isEqualTo(member.getName());
    }

    @Test
    void check_duplicated_member() {
        // given
        Member member1 = new Member("Joe", 21);
        Member member2 = new Member("Joe", 23);

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }
}
