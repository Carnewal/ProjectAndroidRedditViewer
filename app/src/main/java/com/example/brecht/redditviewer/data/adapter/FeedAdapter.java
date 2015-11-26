package com.example.brecht.redditviewer.data.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brecht.redditviewer.R;

/**
 * Created by Brecht on 26/11/2015.
 */
public class FeedAdapter extends CursorRecyclerAdapter<FeedPostViewHolder>{

    private Context me;

    public FeedAdapter(Cursor cursor) {
        super(cursor);
    }

    @Override
    public FeedPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_feed_card, parent, false);
        me = v.getContext();
        return new FeedPostViewHolder(v);
    }

    @Override
    public void onBindViewHolderCursor(FeedPostViewHolder holder, Cursor cursor) {
        holder.insertFromCursorData(cursor, me);
    }


}
