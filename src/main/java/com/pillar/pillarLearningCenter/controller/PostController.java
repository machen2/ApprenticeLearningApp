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

    public List<Post> allPosts;
    public Post lastPost;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String posts(Model model) {
        allPosts = getAllPosts();
        if (allPosts.size() != 0) {
            lastPost = allPosts.get(allPosts.size() - 1);
            model.addAttribute("postList", lastPost);
        }
        return "posts";
    }

    @Autowired
    private PostService postService;

    public List<Post> getAllPosts() {
         return postService.getAllPosts();
    }

    public Post getPostById(Long id) {
        return postService.getPostById(id);
    }
}