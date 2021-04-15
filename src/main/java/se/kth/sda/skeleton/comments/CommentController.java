package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.kth.sda.skeleton.ResourceNotFoundException;
import se.kth.sda.skeleton.posts.PostRepository;

import javax.validation.Valid;

@RestController
public class CommentController{
    CommentRepository commentRepository;
    // Add below after PostRepository is up
    /*PostRepository postRepository;*/
    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Return all comments of a post

    // Create a comment for a given post

    // Return the given comment
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        Comment commentToGet = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok(commentToGet);
    }

    // Delete the given comment
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id){
        Comment commentToBeDeleted = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        commentRepository.delete(commentToBeDeleted);
        return ResponseEntity.ok(commentToBeDeleted);
    }

    // Update a given comment
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @Valid @RequestBody Comment updatedComment){
        commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updatedComment.setId(id);
        commentRepository.save(updatedComment);
        return ResponseEntity.ok(updatedComment);
    }

}