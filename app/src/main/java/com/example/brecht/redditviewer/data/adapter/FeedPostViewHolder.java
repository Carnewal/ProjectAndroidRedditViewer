package com.example.brecht.redditviewer.data.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brecht.redditviewer.R;
import com.example.brecht.redditviewer.data.model.Post;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brecht on 26/11/2015.
 *
 * http://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465
 *
 */
public class FeedPostViewHolder extends RecyclerView.ViewHolder {


    public TextView[] views;

    @Bind(R.id.feedcard_cardview)
    CardView cardView;

    @Bind(R.id.feedcard_thumb)
    ImageView thumbnail;

    @Bind(R.id.feedcard_author)
    TextView author;

    @Bind(R.id.feedcard_title)
    TextView title;


    private Post post;



    public FeedPostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    /**
     * Need to find a way to set the imageview with picasso from here
     *
     * @param cursor
     */
    public void insertFromCursorData(Cursor cursor, Context context) {



        /*int postScore = cursor.getInt(cursor.getColumnIndexOrThrow("score"));
        int postNumComments = cursor.getInt(cursor.getColumnIndexOrThrow("numComments"));
        String postUrl = cursor.getString(cursor.getColumnIndexOrThrow("url"));
        */
        String postTitle = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        //String postDomain = cursor.getString(cursor.getColumnIndexOrThrow("domain"));
        String postAuthor = cursor.getString(cursor.getColumnIndexOrThrow("author"));
        String postThumbnail = cursor.getString(cursor.getColumnIndexOrThrow("thumbnail"));
       /* String postPermalink = cursor.getString(cursor.getColumnIndexOrThrow("permalink"));
        String postSubreddit = cursor.getString(cursor.getColumnIndexOrThrow("subreddit"));
        boolean postIsSelf = cursor.getInt(cursor.getColumnIndexOrThrow("isSelf")) > 0;
*/
        this.title.setText(postTitle);
        this.author.setText(postAuthor);

        if(postThumbnail != null)
            Picasso.with(context).load(postThumbnail)
                    .resize(50,50).centerCrop()
                    .placeholder(R.drawable.error)
                    .error(R.drawable.error)
                    .into(thumbnail);




    }
}
