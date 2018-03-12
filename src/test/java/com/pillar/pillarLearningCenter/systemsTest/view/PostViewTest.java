package com.pillar.pillarLearningCenter.systemsTest.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.service.PostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostViewTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostServiceImpl postServiceMock;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testPostRouteLoadsSuccessfullyWhenNoPostsArePresent() throws Exception {
        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testHtmlView(){
        TestExecutor testExecutor = new TestExecutor();
        testExecutor.execute("classpath:posts/posts.thtest");
        assertTrue(testExecutor.isAllOK());
    }

//    @Test
//    public void testPostsDisplaysTitle() throws Exception {
//
//        MvcResult response = mockMvc.perform(get("/posts")
//                .accept(MediaType.TEXT_HTML))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("text/html;charset=UTF-8"))
//                .andReturn();
//
//      //  Document html = Jsoup.parse(response.getResponse().getContentAsString());
//        //Element titleElement = html.select("h1").first();
//    }
}





