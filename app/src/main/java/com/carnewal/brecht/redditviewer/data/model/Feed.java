package com.carnewal.brecht.redditviewer.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brecht on 24/11/2015.
 *
 * This class will hold the posts and before/after data retreived from the Retrofit call.
 * After the call is made, the posts and before/after data will be added to the appropriate
 * Subreddit Object. This class wil not be saved.
 *
 *
 */
public class Feed {

    private List<Post> posts;

    private String before;
    private String after;

    public Feed() {
        posts = new ArrayList<>();
    }

    public void addPost(Post p) {
        posts.add(p);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
