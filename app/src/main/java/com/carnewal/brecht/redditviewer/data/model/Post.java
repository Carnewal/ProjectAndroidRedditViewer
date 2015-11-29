package com.carnewal.brecht.redditviewer.data.model;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Brecht on 24/11/2015.
 */
@Table(name = "Posts",id = BaseColumns._ID)
public class Post extends Model {

    @Expose
    @Column(name= "id")
    public String id;

    @Expose
    @Column(name= "subreddit")
    public String subreddit;


    @Expose
    @Column(name= "author")
    public String author;


    @Expose
    @Column(name= "score")
    public int score;


    @Expose
    @Column(name= "title")
    public String title;


    @Expose
    @Column(name= "thumbnail")
    public String thumbnail;

    @Expose
    @Column(name= "is_self")
    @SerializedName("is_self")
    public boolean isSelf;

    //Comments

    @Expose
    @Column(name= "num_comments")
    @SerializedName("num_comments")
    public int numComments;


    @Expose
    @Column(name= "permalink")
    public String permalink;

    //Link

    @Expose
    @Column(name= "domain")
    public String domain;

    @Expose
    @Column(name= "url")
    public String url;




    public Post() {
        super();
    }





    //private List<Comment> ...


    ///
    ///
    /// Getters & Setters
    ///
    ///


}
