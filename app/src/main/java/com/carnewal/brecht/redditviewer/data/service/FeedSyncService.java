package com.carnewal.brecht.redditviewer.data.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.carnewal.brecht.redditviewer.data.model.Post;
import com.carnewal.brecht.redditviewer.data.model.Feed;
import com.carnewal.brecht.redditviewer.data.rest.RedditRESTProvider;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Brecht on 28/11/2015.
 */
public class FeedSyncService extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String sub = intent.getExtras().getString("sub");

        Log.i("SubSync: ", sub);

        RedditRESTProvider.getInstance().getService().getFeed(sub).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Response<Feed> response, Retrofit retrofit) {
                for(Post p : response.body().getPosts()) {
                    Log.i("post: ", p.title);
                    p.save();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });


        return 1;


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
