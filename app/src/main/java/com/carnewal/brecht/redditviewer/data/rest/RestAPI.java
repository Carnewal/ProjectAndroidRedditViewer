package com.carnewal.brecht.redditviewer.data.rest;

import com.carnewal.brecht.redditviewer.data.model.Subreddit;
import com.carnewal.brecht.redditviewer.data.model.Feed;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Brecht on 23/11/2015.
 */
public interface RestAPI {

    /**
     * Get All Default Subreddits
     */
    @GET("/subreddits/default.json")
    Call<List<Subreddit>> getDefaultSubredditList();

    /**
     * Get All Public Subreddits
     */
    @GET("/reddits.json")
    Call<List<Subreddit>> getPublicSubredditList();

    /**
     * Get All Default Subreddits in the Hot listing order
     *
     * to limit, use ?limit=XX
     * Max 100
     *
     */


    @GET("/r/{sub}.json")
    Call<Feed> getFeed(@Path("sub") String sub);

    @GET("/r/{sub}/comments/{postid}.json")
    Call<Feed> getPost(@Path("sub") String sub, @Path("postid") String id);



}
