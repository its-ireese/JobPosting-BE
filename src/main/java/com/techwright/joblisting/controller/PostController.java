package com.techwright.joblisting.controller;

import com.techwright.joblisting.repository.PostRepo;
import com.techwright.joblisting.model.PostModel;
import com.techwright.joblisting.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/*
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;
import java.io.IOException;
*/
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo searchRepo;

/*    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }*/

    @GetMapping("/posts")
    public List<PostModel> getAllPosts() {
        return repo.findAll();
    }

    @PostMapping("/post")
    public PostModel addPost(@RequestBody PostModel post){
       return repo.save(post);
    }

    @GetMapping("/posts/{filter}")
    public List<PostModel> search(@PathVariable String filter){
        return searchRepo.findByFilter(filter);
    }
}
