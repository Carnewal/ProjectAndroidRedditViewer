package com.example.brecht.redditviewer.data.net;

import com.example.brecht.redditviewer.data.gson.SubredditFeedDeserializer;
import com.example.brecht.redditviewer.data.gson.SubredditDeserializer;
import com.example.brecht.redditviewer.data.model.Post;
import com.example.brecht.redditviewer.data.model.Subreddit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Brecht on 9/11/2015.
 */
public class RedditRESTProvider {

    private static RedditRESTProvider instance = null;

    private Gson GSON;
    private Retrofit.Builder builder;
    private RestAPI service;

    public synchronized static RedditRESTProvider getInstance() {
        if(instance == null) {
            instance = new RedditRESTProvider();
        }
        return instance;
    }

    private RedditRESTProvider() {

        final Type subListType = new TypeToken<List<Subreddit>>(){}.getType();
        final Type postListType = new TypeToken<List<Post>>(){}.getType();

        GSON = new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(subListType, new SubredditDeserializer())
                .registerTypeAdapter(postListType, new SubredditFeedDeserializer())
                .create();

        builder = new Retrofit.Builder()
                .baseUrl("http://reddit.com")
                .addConverterFactory(GsonConverterFactory.create(GSON));

        service = builder.build().create(RestAPI.class);
    }

    /**
     * Dit gebruiken om de REST API endpoints te banderen. Zie RestAPI.java
     *
     * @return de REST service.
     */
    public RestAPI getService() {
        return this.service;
    }



}