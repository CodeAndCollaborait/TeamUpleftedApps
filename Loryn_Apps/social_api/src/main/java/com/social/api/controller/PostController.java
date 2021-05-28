package com.social.api.controller;

import com.social.api.model.Post;
import com.social.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    //Get
    @GetMapping("/posts")
    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostId
            (@PathVariable(value = "id") Long id) {
        return postRepository.findById(id);
    }

    //Put

    @PutMapping("/posts/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable(value = "id") long id) throws Exception {
        Post postDetails = postRepository.findById(id).orElseThrow(() -> new Exception("Post not found by this ID" + id + "."));
        postDetails.setTitle(post.getTitle());
        postDetails.setContent(post.getContent());
        postDetails.setDescription(post.getDescription());
        postRepository.save(postDetails);
        return postDetails;
    }

    //Post
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    //Delete

    @DeleteMapping("/posts/{id}")
    public Map<Long, String> deletePost(@RequestBody Post post, @PathVariable(value = "id") long id) throws Exception {
        Post postDetails = postRepository.findById(id).orElseThrow(() -> new Exception("Post not found by this ID" + id + "."));
        postRepository.delete(postDetails);
        Map<Long, String> confirmation = new HashMap<>();
        confirmation.put(id, "The post has been deleted");
        return confirmation;
    }
}
