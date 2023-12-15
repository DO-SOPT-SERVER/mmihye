package com.example.seminar.service;


import com.example.seminar.dto.PostRequest;
import com.example.seminar.entity.PostEntity;
import com.example.seminar.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;


    @Transactional
    public void create(PostRequest request) {
        PostEntity post = PostEntity.builder()
                .title(request.title())
                .content(request.content())
                .build();
        postJpaRepository.save(post);
    }

}
