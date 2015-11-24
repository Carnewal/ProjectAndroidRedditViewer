package com.example.brecht.redditviewer.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Brecht on 24/11/2015.
 */
public class Post {

    private String id;

    //Post
    private String subreddit;
    private String author;
    private int score;
    private String title;
    private String thumbnail;

    @SerializedName("is_self")
    private boolean isSelf;

    //Comments

    @SerializedName("num_comments")
    private int numComments;
    private String permalink;

    //Link
    private String domain;
    private String url;



    //private List<Comment> ...


    ///
    ///
    /// Getters & Setters
    ///
    ///

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean is_self() {
        return isSelf;
    }

    public void setSelf(boolean self) {
        this.isSelf = self;
    }
}
