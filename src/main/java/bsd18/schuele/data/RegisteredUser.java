package bsd18.schuele.data;

import javax.persistence.*;

@Entity
@Table(name = "registered_user")
public class RegisteredUser extends User {
    private String password;
    private String email;
    @org.hibernate.annotations.Type(type = "yes_no")
    private boolean confirmed;
    @Enumerated
    private UserType userType = UserType.USER;


    public RegisteredUser() {
    }

    public RegisteredUser(String password, String email, boolean isAdmin) {
        this.password = password;
        this.email = email;
        this.confirmed = isAdmin;
    }

    public RegisteredUser(String userName, String password, String email, boolean isAdmin) {
        super(userName);
        this.password = password;
        this.email = email;
        this.confirmed = isAdmin;
    }

    public RegisteredUser(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public RegisteredUser(String userName, String password, String email) {
        super(userName);
        this.password = password;
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isAdmin() {
        return confirmed;
    }

    public void setAdmin(boolean admin) {
        confirmed = admin;
    }

}
