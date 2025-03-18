package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping
    public ResponseEntity <Post> createPost(@RequestBody Post post){
        Post createdPost= postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts =postService.allPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    @PutMapping("/{id}")
     public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody Post updatePost){
        Post post = postService.updatePost(id,updatePost);
        return new ResponseEntity<>(post,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPost(@RequestParam String term ){
        List <Post> posts = postService.searchPosts(term);
         return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    }


