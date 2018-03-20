package com.pillar.pillarLearningCenter.service;

import com.pillar.pillarLearningCenter.model.Post;

import java.util.List;

public interface PostService {

    public Post getPostByTitle(String title);
    public Post getPostByContent(String content);

    public List<Post> getAllPosts();

    public Post getPostById(Long id);

    public void createPost(Post post);
}
