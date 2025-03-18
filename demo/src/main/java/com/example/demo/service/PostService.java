package com.example.demo.service;


import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(@Valid Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post postExisted = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));

        if (updatedPost.getTitle() != null) {
            postExisted.setTitle(updatedPost.getTitle());
        }
        if (updatedPost.getContent() != null) {
            postExisted.setContent(updatedPost.getContent());
        }
        if (updatedPost.getCategory() != null) {
            postExisted.setCategory(updatedPost.getCategory());
        }
        if (updatedPost.getTags() != null) {
            postExisted.setTags(updatedPost.getTags());
        }

        return postRepository.save(postExisted);
    }

    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException("Post not found");
        }
        postRepository.deleteById(id);
    }
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
    }
    public List<Post> searchPosts(String term) {
        return postRepository.findByTitleContainingOrContentContainingOrCategoryContaining(term, term, term);
    }

    public List<Post> allPosts() {
        return postRepository.findAll();
    }
}