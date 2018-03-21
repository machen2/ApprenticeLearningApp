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
	@Test
	public void contextLoads() {
	}

}
