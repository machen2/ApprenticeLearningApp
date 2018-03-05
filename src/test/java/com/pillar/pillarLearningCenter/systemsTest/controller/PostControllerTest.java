package com.pillar.pillarLearningCenter.systemsTest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostControllerTest {


    @Test
    public void testControllerGetsAListOfPosts() {
//        mock out response for getAllPosts()
//        assign to temporary variable
        assert true;
    }

    @Test
    public void testControllerSetsTitleUsingTheFirstPostTitle(){
        assert false;
    }
}