package com.example.brecht.redditviewer.data.model;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Brecht on 24/11/2015.
 */
public class Subreddit {

    //2qgzt
    private String id;

    //"gadgets
    private String display_name;

    //"imgur.com/..."
    private String header_img;

    //  "header_size": [241,108]
    private int[] header_size;

    //"Reddit gadget guide"
    private String title;

    //"name": "t5_2qgzt",
    private String name;

    //"url": "/r/gadgets/",
    private String url;

    //public_description
    private String public_description;

    private List<Post> posts;


    ///
    ///
    /// Getters & Setters
    ///
    ///



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getHeader_img() {
        return header_img;
    }

    public void setHeader_img(String header_img) {
        this.header_img = header_img;
    }

    public int[] getHeader_size() {
        return header_size;
    }

    public void setHeader_size(int[] header_size) {
        this.header_size = header_size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublic_description() {
        return public_description;
    }

    public void setPublic_description(String public_description) {
        this.public_description = public_description;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append( " Object {" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }

}
