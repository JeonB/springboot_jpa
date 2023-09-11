package com.example.springboot_jpa.jpashop.repository;

import static org.junit.Assert.*;

import com.example.springboot_jpa.jpashop.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    /** Entity Manager를 통한 모든 데이터 변경은 항상 Transactional안에서 이루어져야한다
     * Transactional은 반복적인 테스트를 위해 테스트코드에서는 데이터를 기본적으로 롤백함. 롤백을 막으려면 false설정
     * @throws Exception
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberB");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}