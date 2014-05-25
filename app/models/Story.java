package models;

import play.data.validation.Constraints;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoshutch on 5/21/14.
 */
@Entity
public class Story extends Model {

    @Id
    public Long storyId;

    @Constraints.Required
    public String storyName;
    public String author;

    public static Finder<Long,Story> find = new Finder(
            Long.class, Story.class
    );

    public static List<Story> all(){
        return find.all();
    }

    public static void create (Story story){
        story.save();
    }

    public static void delete (Long storyId){
        find.ref(storyId).delete();
    }
}
