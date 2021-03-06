package com.carnewal.brecht.redditviewer.data.adapter;

import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.carnewal.brecht.redditviewer.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brecht on 26/11/2015.
 */
public class FeedViewHolder extends RecyclerView.ViewHolder {



    @Bind(R.id.feedcard_cardview)
    CardView cardView;

    @Bind(R.id.feedcard_thumb)
    ImageView thumbnail;

    @Bind(R.id.feedcard_author)
    TextView author;

    @Bind(R.id.feedcard_title)
    TextView title;

    @Bind(R.id.feedcard_sub)
    TextView sub;

    @Bind(R.id.feedcard_comments)
    TextView comments;

    @Bind(R.id.feedcard_score)
    TextView score;


    //private Post post;



    public  FeedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    /**
     * Need to find a way to set the imageview with picasso from here
     *
     * @param cursor
     */
    public void insertFromCursorData(Cursor cursor) {


    Log.i("Columns: ", ""+cursor.getColumnCount());
        String postTitle = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String postAuthor = cursor.getString(cursor.getColumnIndexOrThrow("author"));
        String postThumbnail = cursor.getString(cursor.getColumnIndexOrThrow("thumbnail"));

        String postScore = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("score")));
        String postNumComments = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("num_comments")));
        String postUrl = cursor.getString(cursor.getColumnIndexOrThrow("url"));

        String postDomain = cursor.getString(cursor.getColumnIndexOrThrow("domain"));
        String postPermalink = cursor.getString(cursor.getColumnIndexOrThrow("permalink"));
        String postSubreddit = cursor.getString(cursor.getColumnIndexOrThrow("subreddit"));

       // boolean postIsSelf = cursor.getInt(cursor.getColumnIndexOrThrow("is_self")) > 0;

        this.title.setText(postTitle);
        this.sub.setText("in " + postSubreddit);
        this.author.setText("by " + postAuthor);
        this.comments.setText("Comments:" + postNumComments);
        this.score.setText("Score: " + postScore);

        try {
            if(postThumbnail != null)
                Picasso.with(this.itemView.getContext()).load(postThumbnail)
                        .resize(140,140).centerCrop()
                        .placeholder(R.drawable.snoo)
                        .error(R.drawable.snoo)
                        .into(thumbnail);
        } catch(IllegalArgumentException ex) {
            thumbnail.setImageResource(R.drawable.snoo);
        }




    }
}
