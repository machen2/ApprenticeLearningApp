package com.pillar.pillarLearningCenter.service;

import com.pillar.pillarLearningCenter.model.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAllPosts();

    //public Post getPostById(Long id);

    public void createPost(Post post);
}
