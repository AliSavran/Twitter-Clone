package com.alisavran.javatwitterclone.Model;

public class Post {

    public String email;
    public String comment;
    public String downloadUrl;
// ImageView
    public Post(String email, String comment, String downloadUrl) {
        this.email = email;
        this.comment = comment;
        this.downloadUrl = downloadUrl;
    }
    //Comment
    public Post(String email, String comment) {
        this.email = email;
        this.comment = comment;
        this.downloadUrl = null;
    }
}
