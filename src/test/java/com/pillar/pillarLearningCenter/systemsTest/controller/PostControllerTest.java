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

import java.util.List;

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

        assert postController.getAllPosts().size() == 2;
    }

    @Test
    public void testControllerSetsModelWithMultipleTitles() {
        Post onePost = new Post();
        onePost.setTitle("Title One");
        Post twoPost = new Post();
        twoPost.setTitle("Title Two");
        entityManager.persist(onePost);
        entityManager.persist(twoPost);
        entityManager.flush();

        postController.posts(model);

        List<Post> actual = (List<Post>) model.asMap().get("postList");

        assert actual.get(0).getTitle().equals(onePost.getTitle());
        assert actual.get(1).getTitle().equals(twoPost.getTitle());
    }

    @Test
    public void testControllerSetsModelWithMultipleContents() {
        Post onePost = new Post();
        onePost.setContent("Content One");
        Post twoPost = new Post();
        twoPost.setContent("Content Two");
        entityManager.persist(onePost);
        entityManager.persist(twoPost);
        entityManager.flush();

        postController.posts(model);

        List<Post> actual = (List<Post>) model.asMap().get("postList");

        assert actual.get(0).getContent().equals(onePost.getContent());
        assert actual.get(1).getContent().equals(twoPost.getContent());
    }

//    @Test
//    public void testControllerCreatesNewPost(){
//        Post onePost = new Post();
//        onePost.setTitle("Title One");
//        onePost.setContent("Content One");
//        model.addAttribute("Title", onePost.getTitle());
//        model.addAttribute("Content", onePost.getContent());
//        //postController.submitData(model);
//    }

}