package bsd18.schuele.data;

import hibernate_support.HibernateUtil;
import hibernate_support.ISaveAndDelete;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "user")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)    //Splits Elements Completely Objects from subclasses are not listed in the Superclass table
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)         // all in one table new Column is inserted with the Classname to identify the type
//@Inheritance(strategy=InheritanceType.JOINED)             // Join the attributes of the superclass inside this table sub-attributes are stored seperately
public class User implements ISaveAndDelete {
    @Id
    @GeneratedValue
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
