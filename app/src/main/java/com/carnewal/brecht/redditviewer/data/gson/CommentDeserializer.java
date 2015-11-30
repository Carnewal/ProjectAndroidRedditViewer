package com.carnewal.brecht.redditviewer.data.gson;

import com.carnewal.brecht.redditviewer.data.model.Comment;
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

/**
 * Created by Brecht on 30/11/2015.
 */
public class CommentDeserializer implements JsonDeserializer<List<Comment>> {

    public static final Type COMMENT_LIST_TYPE = new TypeToken<List<Comment>>(){}.getType();

    @Override
    public List<Comment> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final JsonArray comments = (JsonArray) json;

        List<Comment> allComments = new ArrayList<>();

        for(JsonElement comment : comments) {

            JsonObject commentList = (JsonObject) comment;
            JsonObject commentData = (JsonObject) commentList.getAsJsonObject("data");

            JsonObject commentReplies = (JsonObject) commentData.getAsJsonObject("replies");
            JsonObject commentRepliesData = (JsonObject) commentReplies.getAsJsonObject("data");


            JsonArray commentRepliesArray = commentRepliesData.getAsJsonArray("children");

            List<Comment> replies = context.deserialize(commentRepliesArray, COMMENT_LIST_TYPE);

            String author = commentData.get("author").getAsString();
            int ups = commentData.get("ups").getAsInt();
            String body = commentData.get("body_html").getAsString();


            Comment c = new Comment(author, ups, body,replies);



            allComments.add(c);

        }

        return allComments;


    }




}
