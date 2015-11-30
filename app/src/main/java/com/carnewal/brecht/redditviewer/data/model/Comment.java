package com.carnewal.brecht.redditviewer.data.model;

import com.activeandroid.Model;

import java.util.List;

/**
 * Created by Brecht on 29/11/2015.
 */
public class Comment extends Model {

    public String author;
    public int ups;
    public String body;

    private List<Comment> replies;


    public Comment(){
        super();
    }

    public Comment(String author, int ups, String body, List<Comment> replies) {
        super();
        this.author = author;
        this.ups = ups;
        this.body = body;
        this.replies = replies;
    }



}
