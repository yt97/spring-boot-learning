package com.scmath.springbootjdbc.dbutils;

/**
 * @author yt
 * @date 2020/3/15/015 18:01
 */
public class User {
    private String userId;
    private String username;
    private String passwprd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswprd() {
        return passwprd;
    }

    public void setPasswprd(String passwprd) {
        this.passwprd = passwprd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", passwprd='" + passwprd + '\'' +
                '}';
    }
}
