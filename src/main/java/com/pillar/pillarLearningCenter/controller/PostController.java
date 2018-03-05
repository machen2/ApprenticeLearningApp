package com.pillar.pillarLearningCenter.controller;

import com.pillar.pillarLearningCenter.model.Post;
import com.pillar.pillarLearningCenter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
//@RequestMapping(value = "/posts")
public class PostController {
    @RequestMapping("/posts")
    public String posts(Model model) {
        Post post = new Post();
        post.setContent("content here");
        post.setTitle("hi title");
        model.addAttribute("post", post);
        return "posts";
    }

    @Autowired
    private PostService postService;

    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Post> getAllPosts() {
         return postService.getAllPosts();
    }

    public Post getPostById(Long id) {
        return postService.getPostById(id);
    }
}
