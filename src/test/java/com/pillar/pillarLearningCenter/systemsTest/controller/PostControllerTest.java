package com.pillar.pillarLearningCenter.systemsTest.controller;

import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@RunWith(SpringRunner.class)
@DataJpaTest
public class PostControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostController postController;


    @Test
    public void testControllerGetsAListOfPosts() {
        Post onePost = new Post();
        Post twoPost = new Post();
        entityManager.persist(onePost);
        entityManager.persist(twoPost);
        entityManager.flush();

        postController.posts();

        assert postController.allPosts.size() == 2;
    }

    @Test
    public void testControllerSetsTitleUsingTheLastPostTitle(){
        Post onePost = new Post();
        onePost.setTitle("Title One");
        Post twoPost = new Post();
        twoPost.setTitle("Title Two");
        entityManager.persist(onePost);
        entityManager.persist(twoPost);
        entityManager.flush();

        postController.posts();

        assert postController.title.equals(twoPost.getTitle());
    }

    @Test
    public void testControllerSetsModelTitleToLastPostTitle() {
        
    }
}