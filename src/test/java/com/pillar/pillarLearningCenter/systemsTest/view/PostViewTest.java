package com.pillar.pillarLearningCenter.systemsTest.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.service.PostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.mockito.BDDMockito.given;
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
    public void testPostRouteLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
//
//    @Test
//    public void testCreateClientSuccessfully() throws Exception {
//        List<Post> expected = new ArrayList<>();
//
//        given(postServiceMock.getAllPosts()).willReturn(expected);
//        mockMvc.perform(get("/posts")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher)jsonPath("$.title", is("Title")))
//                .andExpect((ResultMatcher)jsonPath("$.content", is("This is the content.")));
//    }
}