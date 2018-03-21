package com.pillar.pillarLearningCenter.controller;

import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PostController {

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String posts(Model model) {
        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("postList", allPosts);
        return "posts";
    }

    @RequestMapping(value = "/posts/new", method = RequestMethod.GET)
    public String postsNew() {
        return "new";
    }

    @Autowired
    private PostService postService;

    public Post getPostById(Long id) {
        return postService.getPostById(id);
    }
}