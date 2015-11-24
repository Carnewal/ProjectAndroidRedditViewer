package com.example.brecht.redditviewer.data.gson;

import android.util.Log;

import com.example.brecht.redditviewer.data.model.Subreddit;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brecht on 23/11/2015.
 */
public class SubredditDeserializer implements JsonDeserializer<List<Subreddit>> {
    @Override
    public List<Subreddit> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<Subreddit> output = new ArrayList<>();

        final JsonObject subListingData = ((JsonObject) json).getAsJsonObject("data");
        final JsonArray subs = subListingData.getAsJsonArray("children");

        Gson gson = new Gson();

        for(JsonElement sub : subs) {

            final JsonObject subredditData = sub.getAsJsonObject().getAsJsonObject("data");

            Subreddit s = gson.fromJson(subredditData.toString(), Subreddit.class);

            Log.i("Added default subreddit" , s.getName());
            output.add(s);

        }

        return output;





    }
}
