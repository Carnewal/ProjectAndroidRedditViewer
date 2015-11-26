package com.example.brecht.redditviewer.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brecht.redditviewer.R;
import com.example.brecht.redditviewer.view.Application;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class SubredditFeedFragment extends Fragment {


    @Bind(R.id.feed_recyclerview)
    RecyclerView recyclerView;




    private static final String ARG_SECTION_NUMBER = "section_number";

    public static SubredditFeedFragment newInstance(int sectionNumber) {
        SubredditFeedFragment fragment = new SubredditFeedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SubredditFeedFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        ButterKnife.bind(this, rootView);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);




        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((Application) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));


    }
}
