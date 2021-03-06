package se.kth.sda.skeleton.comments;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import se.kth.sda.skeleton.posts.Post;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents a comment on a {@link Post} as a JPA Entity. This implementation of comment will autogenerate a primary key of type
 * {@link Long} to indicate the current Comment entity. A Comment has a non-null field called {@code owner}. The {@code owner}
 * is a {@link Post} to which the Comment is related. The body of a {@code Comment} can be null.
 */

@Entity
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(nullable = false)
    @NotNull
    private Post owner;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Post getOwner() {
        return owner;
    }

    public void setOwner(Post owner) {
        this.owner = owner;
    }
}