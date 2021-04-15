package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    @TODO create the methods needed to implement the API.
    Don't forget to add necessary annotations.
 */
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/articles")
    public List<Post> listAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/articles/{id}")
    public Post getPost(@PathVariable long id) {
        return postService.findPostById(id);
    }

    @PostMapping("/articles")
    public Post addPost(@RequestBody Post article) {
        return postService.addPost(article);
    }

    @PutMapping("articles/{id}")
    public Post updatePost(@RequestBody Post newPost, @PathVariable Long id) {
        return postService.updatePost(newPost, id);
    }

    @DeleteMapping("/articles/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

}
