package com.example.brecht.redditviewer.data.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brecht.redditviewer.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Brecht on 24/11/2015.
 *
 * https://github.com/codepath/android_guides/wiki/Populating-a-ListView-with-a-CursorAdapter
 *
 */
public class _FeedPostAdapter extends CursorAdapter {




    public _FeedPostAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_feed_post, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView vThumbnail = (ImageView) view.findViewById(R.id.post_thumbnail);
        TextView vComments = (TextView) view.findViewById(R.id.post_comments);
        TextView vScore = (TextView) view.findViewById(R.id.post_score);
        TextView vTitle = (TextView) view.findViewById(R.id.post_title);
        TextView vAuthorSub = (TextView) view.findViewById(R.id.post_authorsub);


        int score = cursor.getInt(cursor.getColumnIndexOrThrow("score"));
        int numComments = cursor.getInt(cursor.getColumnIndexOrThrow("numComments"));
        String url = cursor.getString(cursor.getColumnIndexOrThrow("url"));
        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String domain = cursor.getString(cursor.getColumnIndexOrThrow("domain"));
        String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
        String thumbnail = cursor.getString(cursor.getColumnIndexOrThrow("thumbnail"));
        String permalink = cursor.getString(cursor.getColumnIndexOrThrow("permalink"));
        String subreddit = cursor.getString(cursor.getColumnIndexOrThrow("subreddit"));
        boolean isSelf = cursor.getInt(cursor.getColumnIndexOrThrow("isSelf")) > 0;


        if(thumbnail != null)
            Picasso.with(context).load(thumbnail)
                    .resize(50,50).centerCrop()
                    .placeholder(R.drawable.error)
                    .error(R.drawable.error)
                    .into(vThumbnail);

        vComments.setText(String.valueOf(numComments));
        vScore.setText(String.valueOf(score));

        vTitle.setText(title + "(" + domain + ")");
        vAuthorSub.setText("by " + author + " in " +  subreddit);



    }
}
