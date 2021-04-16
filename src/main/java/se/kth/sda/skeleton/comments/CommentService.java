package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;
import se.kth.sda.skeleton.posts.Post;
import se.kth.sda.skeleton.posts.PostRepository;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    // Return all comments of a post
    public List<Comment> getAllComments(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        return post.getComments();
    }

    // Create a comment for a given post
    public void createComment(Long postId, Comment comment){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId));
        comment.setOwner(post);
        commentRepository.save(comment);
    }

    // Return the given comment
    public Comment getComment(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Delete the given comment
    public void deleteComment(Long id){
        Comment commentToBeDeleted = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        commentRepository.delete(commentToBeDeleted);
    }

    // Update the given comment
    public Comment updateComment(Comment newComment, Long id){
        Comment oldComment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        newComment.setId(oldComment.getId());
        newComment.setOwner(oldComment.getOwner());
        Comment updatedComment = commentRepository.save(newComment);
        return updatedComment;
    }
}