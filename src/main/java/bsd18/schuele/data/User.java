package bsd18.schuele.data;

import hibernate_support.HibernateUtil;
import hibernate_support.ISaveAndDelete;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User implements ISaveAndDelete {
    @Id
    private int userId;
    private String userName;

    @OneToMany
    private List<Post> posts;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean saveDB() {
        return HibernateUtil.commit(this);
    }

    @Override
    public void deleteDB() {

    }
}
