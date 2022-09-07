package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // given 준비
        Member member = new Member("Joe", 21);
        // when 실행
        repository.save(member);
        // then 검증
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        // given
        Member member1 = new Member("Joe", 21);
        repository.save(member1);
        Member member2 = new Member("Alex", 22);
        repository.save(member2);
        Member member3 = new Member("Bob", 23);
        repository.save(member3);
        // when
        Member result = repository.findByName("Bob").get();

        // then
        assertThat(result).isEqualTo(member3);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member("Joe", 21);
        repository.save(member1);
        Member member2 = new Member("Alex", 22);
        repository.save(member2);
        Member member3 = new Member("Bob", 23);
        repository.save(member3);
        // when
        List<Member> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(3);
    }


}