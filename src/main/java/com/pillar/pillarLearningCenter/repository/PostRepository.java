package com.pillar.pillarLearningCenter.repository;

import com.pillar.pillarLearningCenter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    public Post findByTitle(String title);
    public Post findByContent(String content);
    public Post getOne(Long id);
    public Post save(Post post);
}
