package bsd18.schuele.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    private int post_id;
    @ManyToOne
    private User author;

    public Post() {
    }

    public Post(int post_id, User author) {
        this.post_id = post_id;
        this.author = author;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
