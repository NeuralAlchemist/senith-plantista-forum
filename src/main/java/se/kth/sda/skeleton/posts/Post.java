package se.kth.sda.skeleton.posts;

import se.kth.sda.skeleton.comments.Comment;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String authorName;
    @OneToMany(mappedBy = "owner")
    private List<Comment> comments;
    public Post() {
    }

    public Post(String title, String body, String authorName) {
        this.title = title;
        this.body = body;
        this.authorName = authorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
