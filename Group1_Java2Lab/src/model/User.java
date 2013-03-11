package model;

import sun.security.krb5.EncryptionKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/8/13
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = User.USER_NAME_QUERY, query = "SELECT u FROM User u WHERE u.name = :name"),
        @NamedQuery(name = User.ALL_USERS_QUERY, query = "SELECT u FROM User u")})
public class User implements Serializable {
    public static final String USER_NAME_QUERY = "model.User.USER_NAME_QUERY";
    public static final String ALL_USERS_QUERY = "model.User.ALL_USERS_QUERY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "users_groups",
                joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "group_id", nullable = false)})
    private Set<Group> groups;

    public int getUserId(){
        return this.userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

//    public void setClearPassword(String clearPassword){
//        String hashed = Encryption.digest(clearPassword);
//        this.setPassword(hashed);
//    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<Group> groups){
        this.groups = groups;
    }
}
