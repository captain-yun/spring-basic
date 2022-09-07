package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemberRepository memberRepository;
    // Dependency Injection : DI

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        // 생성자 주입 방식으로 객체 생성
        memberService = new MemberService(memberRepository);
    }

    @Test
    void join() {
        // given
        Member member = new Member("Alex", 21);

        // when
        Long id = memberService.join(member);
        // then
        Member result = memberService.findOne(id).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void check_duplicated_member() {
        // given
        Member member1 = new Member("Joe", 21);
        Member member2 = new Member("Alex", 23);

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

}