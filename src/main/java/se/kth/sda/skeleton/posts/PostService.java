package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;
import se.kth.sda.skeleton.posts.Post;
import se.kth.sda.skeleton.posts.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPostById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post newPost, long id) {
        Post post = findPostById(id);
        if (newPost.getTitle() != null) {
            post.setTitle(newPost.getTitle());
        }
        if (newPost.getBody() != null) {
            post.setBody(newPost.getBody());
        }
        if (newPost.getAuthorName() != null) {
            post.setAuthorName(newPost.getAuthorName());
        }
        return postRepository.save(post);
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}

