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
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    /*public Post getPostById(Long id) {
        return postRepository.getOne(id);
    }*/

    public void createPost(Post post){ postRepository.save(post); }
}