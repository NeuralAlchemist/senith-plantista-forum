package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController{
    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Return all comments of a post
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long postId){
        List<Comment> allComments = commentService.getAllComments(postId);
        return ResponseEntity.ok(allComments);
    }
    // Create a comment for a given post
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable Long postId,@RequestBody Comment comment){
        commentService.createComment(postId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
    // Return the given comment
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        Comment commentToGet = commentService.getComment(id);
        return ResponseEntity.ok(commentToGet);
    }

    // Delete the given comment
    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }

    // Update a given comment
 /*    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @Valid @RequestBody Comment updatedComment){
        Comment comment = commentService.updateComment(updatedComment, id);
        return ResponseEntity.ok(comment);
    }*/

}