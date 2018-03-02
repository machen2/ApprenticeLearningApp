package com.pillar.pillarLearningCenter.systemsTest.view;

import com.pillar.pillarLearningCenter.controller.PostController;
import com.pillar.pillarLearningCenter.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostViewTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostService postServiceMock;

    @Test
    public void testPostRouteLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}