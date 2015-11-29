package com.carnewal.brecht.redditviewer.data.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.carnewal.brecht.redditviewer.data.adapter.SubredditAdapter;
import com.carnewal.brecht.redditviewer.data.model.Subreddit;
import com.carnewal.brecht.redditviewer.data.net.RedditRESTProvider;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Brecht on 25/11/2015.
 */
public class SubredditSyncService extends Service {

    public SubredditSyncService() {
        super();
    }


    @Override
    public void onCreate() {
        ActiveAndroid.clearCache();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        
        RedditRESTProvider.getInstance().getService().getPublicSubredditList().enqueue(new Callback<List<Subreddit>>() {
            @Override
            public void onResponse(Response<List<Subreddit>> response, Retrofit retrofit) {
                for(Subreddit s : response.body()) {
                    Log.i("sub: ", s.display_name);
                    s.save();
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

    @Override
    public void onDestroy() {

    }
}
