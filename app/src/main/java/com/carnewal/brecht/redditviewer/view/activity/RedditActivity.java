package com.carnewal.brecht.redditviewer.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

import com.carnewal.brecht.redditviewer.R;
import com.carnewal.brecht.redditviewer.view.fragment.SubredditDrawerFragment;
import com.carnewal.brecht.redditviewer.view.fragment.FeedFragment;

import butterknife.ButterKnife;

public class RedditActivity extends AppCompatActivity
        implements SubredditDrawerFragment.NavigationDrawerCallbacks {


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private SubredditDrawerFragment mSubredditDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActiveAndroid.initialize(this);

        setContentView(R.layout.activity_home);

        mSubredditDrawerFragment = (SubredditDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mTitle = getTitle();

        // Set up the drawer.
        mSubredditDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        ButterKnife.bind(this);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position, String name) {



        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, FeedFragment.newInstance(position + 1, name))
                .commit();

    }

    public void onSectionAttached(String name) {
        mTitle = name;
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mSubredditDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.refresh_button) {

            if(getSupportFragmentManager().findFragmentById(R.id.container) instanceof FeedFragment) {

                FeedFragment current = (FeedFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                current.refreshFeed();
                return true;
            }

            Toast.makeText(getApplication().getApplicationContext(), "Load a Subreddit from the left sidebar before refreshing.", Toast.LENGTH_LONG);
            return true;
        }



        return super.onOptionsItemSelected(item);
    }



    /*@OnClick(R.id.button)
    public void sync(View view) {
        Log.i("Syncing...", "");

        RedditRESTProvider.getInstance().getService().getDefaultSubredditList().enqueue(new Callback<List<Subreddit>>() {
            @Override
            public void onResponse(Response<List<Subreddit>> response, Retrofit retrofit) {
                Log.i(response.message(), ""+response.code());
                for(Subreddit sr : response.body()) {
                    Log.i(sr.getDisplay_name(), "");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Log.i("Error:" + t.getMessage(), "");
            }
        });

    }
*/




}
