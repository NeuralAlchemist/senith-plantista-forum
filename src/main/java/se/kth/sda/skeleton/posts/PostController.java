package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController{
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> listAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable long id) {
        return postService.findPostById(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post newPost) {
        return postService.addPost(newPost);
    }

    @PutMapping("posts/{id}")
    public Post updatePost(@RequestBody Post newPost, @PathVariable Long id) {
        return postService.updatePost(newPost, id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

}
