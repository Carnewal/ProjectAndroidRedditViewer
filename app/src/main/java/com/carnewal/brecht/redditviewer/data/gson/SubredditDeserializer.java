package com.carnewal.brecht.redditviewer.data.gson;

import com.carnewal.brecht.redditviewer.data.model.Subreddit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SubredditDeserializer implements JsonDeserializer<List<Subreddit>> {


    public static final Type SUBREDDIT_LIST_TYPE = new TypeToken<List<Subreddit>>(){}.getType();

    @Override
    public List<Subreddit> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<Subreddit> output = new ArrayList<>();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        final JsonObject subListingData = ((JsonObject) json).getAsJsonObject("data");
        final JsonArray subs = subListingData.getAsJsonArray("children");

        for(JsonElement sub : subs) {
            final JsonObject subredditData = sub.getAsJsonObject().getAsJsonObject("data");
            Subreddit s = gson.fromJson(subredditData.toString(), Subreddit.class);
            output.add(s);
        }

        return output;

    }
}
