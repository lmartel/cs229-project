package Project.Features;

import Project.Comment;

/**
 * Created by daria on 11/15/14.
 */
public class CharLengthFeature implements Feature {
    @Override
    public double value(Comment comment) {
        return (comment.getText()).length();
    }
}
