package com.example.brecht.redditviewer.data.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.brecht.redditviewer.data.model.Post;
import com.example.brecht.redditviewer.data.model.Subreddit;
import com.example.brecht.redditviewer.data.net.RedditRESTProvider;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Brecht on 25/11/2015.
 */
public class SyncService extends Service {


    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        RedditRESTProvider.getInstance().getService().getPublicSubredditList().enqueue(new Callback<List<Subreddit>>() {
            @Override
            public void onResponse(Response<List<Subreddit>> response, Retrofit retrofit) {

                //save to db

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        RedditRESTProvider.getInstance().getService().getPublicSubredditList().enqueue(new Callback<List<Subreddit>>() {
            @Override
            public void onResponse(Response<List<Subreddit>> response, Retrofit retrofit) {

                //save to db

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        return 1;


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }
}
