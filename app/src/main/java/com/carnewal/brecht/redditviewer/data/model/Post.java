package com.carnewal.brecht.redditviewer.data.model;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Brecht on 24/11/2015.
 */
@Table(name = "Posts",id = BaseColumns._ID)
public class Post extends Model {


    public String id;

    @Column(name= "subreddit")
    public String subreddit;


    @Column(name= "author")
    public String author;


    public int score;

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
