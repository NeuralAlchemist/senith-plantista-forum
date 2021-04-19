package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;
import se.kth.sda.skeleton.posts.Post;
import se.kth.sda.skeleton.posts.PostRepository;

import java.util.List;

/**
 * Represents the service layer. It contains defined functionalities according to business logic for Comments.
 */
@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    /**
     * Constructs a CommentService and automatically assigns its {@code postRepository} and {@code commentRepository} fields.
     * @param commentRepository an object that implements interface CommentRepository
     * @param postRepository an object that implements interface PostRepository
     */
    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    /**
     * Returns all Comments of a Post with the given {@code postId} or throws a {@link ResourceNotFoundException} if there is no
     * Post with the given {@code postId}.
     * @param postId the Post whose entire list of Comments is returned
     * @return a list of Comments of the Post with id equal to {@code postId}
     * @throws ResourceNotFoundException if there is no Post with the given {@code postId}
     */
    public List<Comment> getAllComments(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        return post.getComments();
    }

    /**
     * Creates a Comment for a Post with the given {@code postId} or throws a {@link ResourceNotFoundException} if there is no Post with the given {@code postId}.
     * @param postId the Post for whom a new Comment is created
     * @param comment the Comment that will be associated with the Post whose id is {@code postId}
     * @throws ResourceNotFoundException if there is no Post with the given {@code postId}
     */
    public void createComment(Long postId, Comment comment){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        comment.setOwner(post);
        commentRepository.save(comment);
    }

    /**
     * Returns a Comment with the given {@code id} or throws a {@link ResourceNotFoundException} if there is no Comment with the given
     * {@code id}.
     * @param id the id used to find the Comment associated with it
     * @return Comment associated with the given {@code id}
     * @throws ResourceNotFoundException if there is no Comment with the given {@code id}
     */
    public Comment getComment(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * Deletes a Comment with the given {@code id} or throws a {@link ResourceNotFoundException} if there is no
     * Comment with the given {@code id}.
     * @param id the id used to find the Comment associated with it and delete it
     * @throws ResourceNotFoundException if there is no Comment with the given {@code id}
     */
    public void deleteComment(Long id){
        Comment commentToBeDeleted = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        commentRepository.delete(commentToBeDeleted);
    }
}