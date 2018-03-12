package com.pillar.pillarLearningCenter.systemsTest;

import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PillarLearningCenterApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostController postController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void whenFindByTitle_thenReturnPost() {
		// given
		Post alex = new Post();
		alex.setTitle("Hi Alex");
		entityManager.persist(alex);
		entityManager.flush();

		// when
		Post found = postRepository.findByTitle(alex.getTitle());

		// then
		assertThat(found.getTitle())
				.isEqualTo(alex.getTitle());
	}

	@Test
	public void whenFindByContent_thenReturnPost() {
		// given
		Post expected = new Post();
		expected.setContent("Hi Alex");
		entityManager.persist(expected);
		entityManager.flush();

		// when
		Post actual = postRepository.findByContent(expected.getContent());

		// then
		assertThat(actual.getContent())
				.isEqualTo(expected.getContent());
	}

	@Test
    public void whenGetAllPosts_thenAllPostsAreReturned() {
	    entityManager.persist(new Post());
	    entityManager.persist(new Post());
	    entityManager.flush();

        List<Post> allPosts = postController.getAllPosts();
        assertThat(allPosts.size()).isEqualTo(2);
    }

	@Test
    public void whenGetOnePost_thenPostIsReturned() {
	    Post post = new Post();
	    entityManager.persist(post);
	    entityManager.flush();

        // when
        Post actual = postController.getPostById(post.getId());

        // then
        assertThat(actual).isEqualTo(post);
    }
}
