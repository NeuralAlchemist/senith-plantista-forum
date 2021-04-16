package se.kth.sda.skeleton.comments;


import com.fasterxml.jackson.annotation.JsonIgnore;
import se.kth.sda.skeleton.posts.Post;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    @ManyToOne
    @JsonIgnore
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