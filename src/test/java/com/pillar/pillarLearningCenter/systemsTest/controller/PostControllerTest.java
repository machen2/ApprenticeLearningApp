package com.pillar.pillarLearningCenter.systemsTest.controller;

import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService postService;


    private Model model = new ExtendedModelMap();

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testControllerPopulatesModelDataFromService() {
        Post onePost = new Post();
        onePost.setTitle("Title One");
        Post twoPost = new Post();
        twoPost.setTitle("Title Two");
        List<Post> expected = new ArrayList<>();
        expected.add(onePost);
        expected.add(twoPost);
        Mockito.when(postService.getAllPosts()).thenReturn(expected);

        postController.posts(model);

        List<Post> actual = (List<Post>) model.asMap().get("postList");

        assertEquals(actual, expected);
    }

    @Test
    public void testControllerUsesServiceToCreateAPost(){
        Post post = new Post();
        post.setTitle("Dummy Title");
        post.setContent("Dummy Content");
        postController.postsNew();
        Mockito.verify(postService).createPost(post);
    }

    @Test
    public void posts_shouldReturnPostsRouteString_whenCalled(){
        assertEquals("posts", postController.posts(model));
    }

    @Test
    public void postsNew_shouldReturnNewRouteString_WhenCalled(){
        assertEquals("new", postController.postsNew());
    }

}