package com.carnewal.brecht.redditviewer;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Brecht on 28/11/2015.
 */
public class MyApplication extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
