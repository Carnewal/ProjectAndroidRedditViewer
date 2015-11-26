package com.example.brecht.redditviewer.data.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.example.brecht.redditviewer.R;

/**
 * Created by Brecht on 24/11/2015.
 */
public class SubredditAdapter extends CursorAdapter {




    public SubredditAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_feed_post, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
