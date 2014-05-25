package controllers;

import models.Story;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    static Form<Story> storyForm = Form.form(Story.class);

    public static Result index() {
        return ok(
                "Hello World"
        );
    }

    public static Result stories() {
        return ok(
                views.html.index.render(Story.all(), storyForm)
        );
    }

    public static Result newStory() {
        Form<Story> filledForm = storyForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.index.render(Story.all(), filledForm)
            );
        } else {
            Story.create(filledForm.get());
            return redirect(routes.Application.stories());
        }
    }

    public static Result deleteStory(Long storyId) {
        Story.delete(storyId);
        return redirect(routes.Application.stories());
    }

}
