package com.pillar.pillarLearningCenter.systemsTest.service;

import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.service.PostService;
import com.pillar.pillarLearningCenter.service.PostServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceTest {
    @Autowired
    PostService postService;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatePost(){
        Post post = new Post();
        post.setTitle("Title One");
        post.setContent("Content is Here");

        postService.createPost(post);

        Post resultPost = entityManager.find(Post.class, post.getId());

        assertEquals(resultPost, post);
    }

}
