package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents the controller layer (or the API). This exposes application functionality of Comment as RESTful webservices.
 */
@RestController
public class CommentController{
    CommentService commentService;

    /**
     * Constructs a CommentController and automatically assigns its {@code commentService} field.
     * @param commentService an object that implements interface CommentService
     */
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Handler method for endpoint "/posts/{postId}/comments" with GET HttpRequest. Returns a {@link ResponseEntity}
     * containing the list of Comments associated with a Post of the given {@code postId} and HTTP status {@code OK}.
     * @param postId the Post whose entire list of Comments is returned
     * @return {@link ResponseEntity} containing the list of Comments associated with a Post of the given {@code postId}
     * and HTTP status {@code OK}
     */
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long postId){
        List<Comment> allComments = commentService.getAllComments(postId);
        return ResponseEntity.ok(allComments);
    }

    /**
     * Handler method for endpoint "/posts/{postId}/comments" with POST HttpRequest. Returns a {@link ResponseEntity} containing the created
     * comment and HTTP status {@code OK}. Requires that the HttpRequest from client include Comment object {@code comment}
     * which is the Comment to be created.
     * @param postId the Post for whom a new Comment is created
     * @param comment the comment that will be associated with the Post whose id is {@code postId}
     * @return {@link ResponseEntity} containing the created Comment and HTTP status {@code OK}
     */
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable Long postId,@RequestBody Comment comment){
        commentService.createComment(postId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    /**
     * Handler method for endpoint "/comments/{id}" with GET HttpRequest. Returns a {@link ResponseEntity} containing a Comment with the
     * given {@code id} and HTTP status {@code OK}.
     * @param id the id used to find the Comment associated with it
     * @return {@link ResponseEntity} containing a Comment with the given {@code id} and HTTP status {@code OK}
     */
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        Comment commentToGet = commentService.getComment(id);
        return ResponseEntity.ok(commentToGet);
    }

    /**
     * Handler method for endpoint "/comments/{id}" with DELETE HttpRequest. Invokes a HTTP {@link ResponseStatus} of
     * NO_CONTENT. Deletes the Comment given by {@code id}.
     * @param id the id used to find the Comment associated with it and delete it
     */
    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }

}