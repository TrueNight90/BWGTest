package org.yjr.login.entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String name;
    private String password;
    @Column(name = "createDate")
    private String createDate;
    private String accessbymb;
    private String accessbymail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAccessbymb() {
        return accessbymb;
    }

    public void setAccessbymb(String accessbymb) {
        this.accessbymb = accessbymb;
    }

    public String getAccessbymail() {
        return accessbymail;
    }

    public void setAccessbymail(String accessbymail) {
        this.accessbymail = accessbymail;
    }
}
