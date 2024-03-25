package jeong.sun.Repository;

import jeong.sun.domain.Member;
import jeong.sun.repository.MemberRepository;
import jeong.sun.repository.MemoryMemberRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result1 = repository.findByName("spring1").get();
        Member result2 = repository.findByName("spring2").get();

        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);
    }

    @Test
    public void findAll() {

        List<Member> members = new ArrayList<>();

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        members.add(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        members.add(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);
        members.add(member3);

        List<Member> results = repository.findAll();
        assertThat(results).isEqualTo(members);

    }
}
