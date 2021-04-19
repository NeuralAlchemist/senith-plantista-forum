package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents the controller layer (or the API). This exposes application functionality of Post as RESTful webservices.
 */
@RestController
public class PostController{
    private final PostService postService;

    /**
     * Constructs a PostController and automatically assigns its {@code postService} field.
     * @param postService an object that implements interface PostService
     */
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Handler method for endpoint "/posts" with GET HttpRequest.
     * @return
     */
    @GetMapping("/posts")
    public List<Post> listAllPosts() {
        return postService.findAllPosts();
    }

    /**
     * Handler method for endpoint "/posts/{id}" with GET HttpRequest.
     * @param id returns the Post associated with this {@code id}
     * @return
     */
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable long id) {
        return postService.findPostById(id);
    }

    /**
     * Handler method for endpoint "/posts" with POST HttpRequest. Requires that the HttpRequest from client include
     * Post Object {@code article} which is the Post to be created.
     * @param article
     * @return
     */
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post newPost) {
        return postService.addPost(newPost);
    }

    /**
     * Handler method for endpoint "/posts/{id}" with POST HttpRequest. Requires that the HttpRequest from client include
     * Post Object {@code newPost} which is the updated Post.
     * @param newPost the updated Post which will replace the post with the given {@code id}
     * @param id updates the Post associated with this {@code id}
     * @return
     */
    @PutMapping("posts/{id}")
    public Post updatePost(@RequestBody Post newPost, @PathVariable Long id) {
        return postService.updatePost(newPost, id);
    }

    /**
     * Handler method for endpoint "/posts/{id}" with POST HttpRequest. Deletes the Post given by {@code id}.
     * @param id deletes the Post associated with this {@code id}
     */
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

}
