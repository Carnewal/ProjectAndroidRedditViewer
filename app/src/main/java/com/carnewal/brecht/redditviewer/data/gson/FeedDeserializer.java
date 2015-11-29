package com.carnewal.brecht.redditviewer.data.gson;

import android.util.Log;

import com.carnewal.brecht.redditviewer.data.model.Post;
import com.carnewal.brecht.redditviewer.data.model.Feed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Brecht on 24/11/2015.
 *
 * Deserializer for Subreddit Feed data
 *
 *
 *
 *
 *
 */
public class FeedDeserializer implements JsonDeserializer<Feed> {
    @Override
    public Feed deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Feed feed = new Feed();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        final JsonObject postListingData = ((JsonObject) json).getAsJsonObject("data");
        final JsonArray postsData = postListingData.getAsJsonArray("children");



        String before;
        try { before =  postListingData.get("before").getAsString();
        } catch(Exception e) {before=null;}

        String after;
        try { after = postListingData.get("after").getAsString();
        } catch(Exception e) {after=null;}

        Log.i("Adding posts:", postsData.toString());



        for(JsonElement post : postsData) {
            final JsonObject postData = post.getAsJsonObject().getAsJsonObject("data");

            Log.i("data: " , postData.toString() );

            Post p = gson.fromJson(postData.toString(), Post.class);
            Log.i("Post Added:", p.title);
            feed.addPost(p);
        }



        return feed;

    }
}
