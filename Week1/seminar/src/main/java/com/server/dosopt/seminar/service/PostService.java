package com.server.dosopt.seminar.service;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.domain.Post;
import com.server.dosopt.seminar.dto.request.post.PostCreateRequest;
import com.server.dosopt.seminar.dto.response.PostGetResponse;
import com.server.dosopt.seminar.reposiotry.MemberJpaRepository;
import com.server.dosopt.seminar.reposiotry.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest requst, Long memberId){
        Member member = memberJpaRepository.findByIdOrThorw(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                .member(member)
                .title(requst.title())
                .content(requst.content()).build());

//        Post savedPost = postJpaRepository.saveAll();
        return post.getId().toString();
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(PostGetResponse::of)
                .toList();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }

}
