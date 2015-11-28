package com.carnewal.brecht.redditviewer.data.model;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Brecht on 24/11/2015.
 */
@Table(name = "Subreddits", id = BaseColumns._ID)
public class Subreddit extends Model {


    public Subreddit() {
        super();
    }

    public String lastBefore;
    public String lastAfter;

    @Expose
    @Column(name = "id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public String id; //2qgzt

    @Expose
    @Column(name = "display_name", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public String display_name; //gadgets

    @Expose
    public String header_img; // imgur.com/..

    @Expose
    public int[] header_size; //  "header_size": [241,108]

    @Expose
    public String title; //"Reddit gadget guide"
    @Expose
    public String name;//"name": "t5_2qgzt",
    @Expose
    public String url; //"url": "/r/gadgets/",
    @Expose
    public String public_description;//public_description

    public List<Post> posts;



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
