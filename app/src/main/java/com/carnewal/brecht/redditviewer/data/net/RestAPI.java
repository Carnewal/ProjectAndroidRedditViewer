package com.carnewal.brecht.redditviewer.data.net;

import com.carnewal.brecht.redditviewer.data.model.Post;
import com.carnewal.brecht.redditviewer.data.model.Subreddit;
import com.carnewal.brecht.redditviewer.data.model.SubredditFeed;

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


    @GET("/r/{sub}/hot.json")
    Call<SubredditFeed> getSubredditHotPosts(@Path("sub") String sub);



}
