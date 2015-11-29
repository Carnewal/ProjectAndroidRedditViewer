package com.carnewal.brecht.redditviewer.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.activeandroid.content.ContentProvider;
import com.activeandroid.query.Delete;
import com.carnewal.brecht.redditviewer.R;
import com.carnewal.brecht.redditviewer.data.adapter.FeedAdapter;
import com.carnewal.brecht.redditviewer.data.model.Post;
import com.carnewal.brecht.redditviewer.data.service.FeedSyncService;
import com.carnewal.brecht.redditviewer.view.activity.RedditActivity;
import com.carnewal.brecht.redditviewer.view.util.ItemClickSupport;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedFragment extends Fragment {


    @Bind(R.id.feed_recyclerview)
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SUBREDDIT_NAME = "subreddit_name";

    public static FeedFragment newInstance(int listNumber, String subName) {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, listNumber);
        args.putString(ARG_SUBREDDIT_NAME, subName);
        fragment.setArguments(args);

        return fragment;
    }

    public FeedFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater nfltr, ViewGroup container, Bundle savedInstanceState) {


        View rootView = nfltr.inflate(R.layout.feed_rv_fragment, container, false);
        ButterKnife.bind(this, rootView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


        new Delete().from(Post.class).execute();

        recyclerView.setAdapter(new FeedAdapter(null));



        getActivity().getSupportLoaderManager().initLoader(1, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int arg0, Bundle cursor) {
                return new CursorLoader(getActivity(),
                        ContentProvider.createUri(Post.class, null),
                        null, null, null, null
                );
            }

            @Override
            public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
                ((FeedAdapter) recyclerView.getAdapter()).swapCursor(cursor);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> arg0) {
                ((FeedAdapter) recyclerView.getAdapter()).swapCursor(null);
            }
        });


        Intent i = new Intent(getActivity(), FeedSyncService.class);
        i.putExtra("sub", getArguments().getString(ARG_SUBREDDIT_NAME));
        getActivity().startService(i);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.i("Click:", "short");
                Toast.makeText(v.getContext(), "Lol", Toast.LENGTH_SHORT);
            }
        }).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                Log.i("Click:", "long");
                Toast.makeText(v.getContext(), "Long lol", Toast.LENGTH_SHORT);
                return true;
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(-1)) {
                    onScrolledToTop();
                } else if (!recyclerView.canScrollVertically(1)) {
                    onScrolledToBottom();
                } else if (dy < 0) {
                    onScrolledUp();
                } else if (dy > 0) {
                    onScrolledDown();
                }
            }
        });

        return rootView;
    }

    private void onScrolledUp() {
        Log.i("Scroll:", "Scrolled up");
    }

    private void onScrolledDown() {
        Log.i("Scroll:" , "Scrolled Down");
        
    }

    private void onScrolledToBottom() {
        Log.i("Scroll:" , "Scrolled To Bottom");
        
    }

    private void onScrolledToTop() {
        Log.i("Scroll:" , "Scrolled To Top");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((RedditActivity) activity).onSectionAttached(
                getArguments().getString(ARG_SUBREDDIT_NAME));
    }


    public void refresh() {

        Toast.makeText(getContext(),"I'm a fragment ehhehehe refreesshhh",Toast.LENGTH_LONG).show();

    }
}
