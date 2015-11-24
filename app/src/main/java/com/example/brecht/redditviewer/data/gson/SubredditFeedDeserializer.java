package com.example.brecht.redditviewer.data.gson;

import com.example.brecht.redditviewer.data.model.Post;
import com.example.brecht.redditviewer.data.model.Subreddit;
import com.example.brecht.redditviewer.data.model.SubredditFeed;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brecht on 24/11/2015.
 */
public class SubredditFeedDeserializer implements JsonDeserializer<SubredditFeed> {
    @Override
    public SubredditFeed deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<Post> posts = new ArrayList<>();
        SubredditFeed feed = new SubredditFeed();
        Gson gson = new Gson();

        final JsonObject postListingData = ((JsonObject) json).getAsJsonObject("data");
        final JsonArray postsData = postListingData.getAsJsonArray("children");



        String before;
        try { before =  postListingData.get("before").getAsString();
        } catch(Exception e) {before=null;}

        String after;
        try { after = postListingData.get("after").getAsString();
        } catch(Exception e) {after=null;}


        for(JsonElement post : postsData) {
            final JsonObject postData = post.getAsJsonObject().getAsJsonObject("data");
            Post p = gson.fromJson(postData.toString(), Post.class);
            posts.add(p);
        }







        return feed;

    }
}
