package com.carnewal.brecht.redditviewer.data.adapter;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carnewal.brecht.redditviewer.R;

/**
 * Created by Brecht on 26/11/2015.
 */
public class FeedAdapter extends CursorRecyclerAdapter<FeedPostViewHolder>{


    public FeedAdapter(Cursor cursor) {
        super(cursor);
    }

    @Override
    public FeedPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_rv_card, parent, false);
        return new FeedPostViewHolder(v);
    }

    @Override
    public void onBindViewHolderCursor(FeedPostViewHolder holder, Cursor cursor) {
        holder.insertFromCursorData(cursor);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
