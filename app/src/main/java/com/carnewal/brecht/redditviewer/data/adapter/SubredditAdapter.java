package com.carnewal.brecht.redditviewer.data.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.carnewal.brecht.redditviewer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brecht on 24/11/2015.
 */
public class SubredditAdapter extends CursorAdapter {

    @Bind(R.id.subName)
    TextView subName;

    public SubredditAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.sub_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ButterKnife.bind(this, view);
        String display_name = cursor.getString(cursor.getColumnIndexOrThrow("display_name"));
        subName.setText(display_name);
        Log.i("adapt", cursor.getPosition() + "/" + cursor.getCount() + ", " + display_name);
    }
}
