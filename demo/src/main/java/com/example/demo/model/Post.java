package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id; // Lowercase 'i'

    @NotBlank(message = "Title is required")
    private String title; // Lowercase 't'

    @NotBlank(message = "Content is required")
    @Column(columnDefinition="TEXT")
    private String content; // Lowercase 'c'

    @NotBlank(message = "Category is required")
    private String category; // Lowercase 'c'

    @NotEmpty(message = "Tags are required")
    @ElementCollection
    private List<String> tags; // Lowercase 't'

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // Lowercase 'c'

    @UpdateTimestamp
    private LocalDateTime updatedAt; // Lowercase 'u'

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}