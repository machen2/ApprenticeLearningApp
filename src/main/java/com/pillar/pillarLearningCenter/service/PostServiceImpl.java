package com.pillar.pillarLearningCenter.service;

import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public Post getPostByContent(String content) {
        return postRepository.findByContent(content);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.getOne(id);
    }
}