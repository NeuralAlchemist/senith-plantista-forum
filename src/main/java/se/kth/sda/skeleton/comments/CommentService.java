package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;
import se.kth.sda.skeleton.posts.Post;
import se.kth.sda.skeleton.posts.PostRepository;

import java.util.List;

/**
 * Represents the service layer. It contains defined functionalities according to business logic for comments.
 */
@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    /**
     * Returns all comments of a post with the given{@code postId} or throws a {@link ResourceNotFoundException} if there is no post with the given {@code postId}.
     * @param postId the post who's entire list of comments is returned
     * @return a list of comments of the post with id equal to {@code postId}
     * @throws ResourceNotFoundException if there is no post with the given {@code postId}
     */
    public List<Comment> getAllComments(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        return post.getComments();
    }

    /**
     * Creates a comment for a post with the given {@code postId} or throws a {@link ResourceNotFoundException} if there is no post with the given {@code postId}.
     * @param postId the post for whom a new comment is created
     * @param comment the comment that will be associated with the post whose id is {@code postId}
     * @throws ResourceNotFoundException if there is no post with the given {@code postId}
     */
    public void createComment(Long postId, Comment comment){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        comment.setOwner(post);
        commentRepository.save(comment);
    }

    /**
     * Returns a comment with the given {@code id} or throws a {@link ResourceNotFoundException} if there is no comment with the given
     * {@code id}
     * @param id the id used to find the comment associated with it
     * @return comment associated with the given {@code id}
     * @throws ResourceNotFoundException if there is no comment with the given {@code id}
     */
    public Comment getComment(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * Deletes a comment with the given {@code id} or throws a {@link ResourceNotFoundException} if there is no
     * comment with the given {@code id}
     * @param id the id used to find the comment associated with it and delete it
     * @throws ResourceNotFoundException if there is no comment with the given {@code id}
     */
    public void deleteComment(Long id){
        Comment commentToBeDeleted = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        commentRepository.delete(commentToBeDeleted);
    }

    // Update the given comment
/*    public Comment updateComment(Comment newComment, Long id){
        Comment oldComment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        newComment.setId(oldComment.getId());
        newComment.setOwner(oldComment.getOwner());
        Comment updatedComment = commentRepository.save(newComment);
        return updatedComment;
    }*/
}