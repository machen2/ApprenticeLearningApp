package com.pillar.pillarLearningCenter.systemsTest.controller;

import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostController postController;

    private Model model = new ExtendedModelMap();

    @Test
    public void testControllerGetsAListOfPosts() {
        Post onePost = new Post();
        Post twoPost = new Post();
        entityManager.persist(onePost);
        entityManager.persist(twoPost);
        entityManager.flush();

        postController.posts(model);

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

        postController.posts(model);

        assert postController.title.equals(twoPost.getTitle());
    }

    @Test
    public void testControllerSetsModelTitleToLastPostTitle() {
        Post onePost = new Post();
        onePost.setTitle("Title One");
        Post twoPost = new Post();
        twoPost.setTitle("Title Two");
        entityManager.persist(onePost);
        entityManager.persist(twoPost);
        entityManager.flush();

        postController.posts(model);

        Post actual = (Post) model.asMap().get("posts");

        assert actual.getTitle().equals(twoPost.getTitle());
    }
}