package com.carnewal.brecht.redditviewer.data.gson;

import android.util.Log;

import com.carnewal.brecht.redditviewer.data.model.Comment;
import com.carnewal.brecht.redditviewer.data.model.Post;
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

/**
 * Created by Brecht on 29/11/2015.
 *
 */
public class PostDeserializer implements JsonDeserializer<Post> {
    @Override
    public Post deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        final JsonArray postAndComments = ((JsonArray) json).getAsJsonArray();

        final JsonObject postListing = (JsonObject) postAndComments.get(0);
        final JsonObject commentListing = (JsonObject) postAndComments.get(1);

        final JsonObject postListingData = postListing.getAsJsonObject("data");
        final JsonObject commentListingData = commentListing.getAsJsonObject("data");

        final JsonArray posts = postListingData.getAsJsonArray("children");
        final JsonObject post = ((JsonObject) posts.get(0));
        final JsonObject postData = (JsonObject) post.getAsJsonObject("data");
        final String postId = postData.get("id").getAsString();



        final JsonElement comments = commentListingData.getAsJsonArray("children");

        final JsonObject thisPost = (JsonObject) posts.get(0);
        final JsonObject thisPostdata = thisPost.getAsJsonObject("data");

        Log.i("Post Id: ", postId);

        Post p = Post.getPostByPostId(postId);

        List<Comment> postReplies = context.deserialize(comments, CommentDeserializer.COMMENT_LIST_TYPE);


        //p.comments = postReplies;

        return p;



     /*   for(JsonElement comment : comments) {
            final JsonObject commentData = comment.getAsJsonObject().getAsJsonObject("data");

            Comment c = context.deserialize(comment, Comment.class);
            Subreddit s = gson.fromJson(commentData.toString(), Subreddit.class);
            output.add(s);
        } */


    }
}
