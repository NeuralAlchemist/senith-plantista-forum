package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.ResourceNotFoundException;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    // Add below after PostRepository is up
    /*PostRepository postRepository;*/

    @Autowired

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Return all comments of a post

    // Create a comment for a given post

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
        commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        newComment.setId(id);
        Comment updatedComment = commentRepository.save(newComment);
        return updatedComment;
    }
}