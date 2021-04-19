package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;

import java.util.List;

/**
 * Represents the service layer. It contains defined functionalities according to business logic for Posts.
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    /**
     * Constructs a PostService and automatically assigns its {@code postRepository} field
     * @param postRepository an object that implements interface PostRepository
     */
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Returns all Posts currently in the repository.
     * @return a list of all posts currently in the repository.
     */
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    /**
     * Returns a Post with the given {@code id} or throws a {@link ResourceNotFoundException} if there is no Post with the given
     * {@code id}
     * @param id the id used to find the Post associated with it
     * @return Post associated with the given {@code id}
     * @throws ResourceNotFoundException if there is no Post with the given {@code id}
     */
    public Post findPostById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * Adds the given Post to the {@link PostRepository} and returns the added Post.
     * @param post the Post to be added into the {@link PostRepository}
     * @return Post added to the {@link PostRepository}
     */
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    /**
     * Updates the Post with the given {@code id} with the given {@code newPost}.
     * @param newPost the Post which will replace the Post at given {@code id}
     * @param id the id used to find the Post to be updated
     * @return
     */
    public Post updatePost(Post newPost, long id) {
        Post post = findPostById(id);
        if (newPost.getBody() != null) {
            post.setBody(newPost.getBody());
        }
        return postRepository.save(post);
    }

    /**
     * Deletes Post with the given {@code id}
     * @param id the id used to find the Post to be deleted
     */
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}

