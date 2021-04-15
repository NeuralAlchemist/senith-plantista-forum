package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/*
    @TODO Implement service methods.
 */
@Service
public class PostService {

    private final PostRepository articleRepository;

    @Autowired
    public PostService(PostRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Post> findAllPosts() {
        return articleRepository.findAll();
    }

    public Post findPostById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Post addPost(Post article) {
        return articleRepository.save(article);
    }

    public Post updatePost(Post newPost, long id) {
        Post article = findPostById(id);
        if (newPost.getBody() != null) {
            article.setBody(newPost.getBody());

        return articleRepository.save(article);
    }

    public void deletePost(long id) {
        articleRepository.deleteById(id);
    }
}

