package com.server.dosopt.seminar.reposiotry;

import com.server.dosopt.seminar.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrThrow(Long memberId){
        return findById(memberId)
                .orElseThrow(() ->new EntityNotFoundException("해당하는 회원이 없습니다"));
    }
}