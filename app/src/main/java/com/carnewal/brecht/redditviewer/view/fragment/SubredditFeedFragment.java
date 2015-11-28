package com.carnewal.brecht.redditviewer.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carnewal.brecht.redditviewer.R;
import com.carnewal.brecht.redditviewer.view.activity.RedditActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SubredditFeedFragment extends Fragment {


    @Bind(R.id.feed_recyclerview)
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SUBREDDIT_NAME = "subreddit_name";

    public static SubredditFeedFragment newInstance(int listNumber, String subName) {
        SubredditFeedFragment fragment = new SubredditFeedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, listNumber);
        args.putString(ARG_SUBREDDIT_NAME, subName);
        fragment.setArguments(args);
        return fragment;
    }

    public SubredditFeedFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater nfltr, ViewGroup container, Bundle savedInstanceState) {

        View rootView = nfltr.inflate(R.layout.feed_rv_fragment, container, false);

        ButterKnife.bind(this, rootView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        // recyclerView.setAdapter(new FeedAdapter());


        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((RedditActivity) activity).onSectionAttached(
                getArguments().getString(ARG_SUBREDDIT_NAME));
    }


    public void refresh() {

        // Todo! start new service that syncs the sub feed & puts it in the database
        // maybe also swap cursors on the recyclerview adapter?



    }


}
