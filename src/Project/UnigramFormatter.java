package Project;


public class UnigramFormatter extends LabeledFormatter {

    public UnigramFormatter(Labeling labeling) {
        super(labeling, ",");
    }

    public UnigramFormatter(){
        super(null, ",");
    }

    @Override
    public String getFeatures(Comment comment) {
        return comment.getText();
    }
}
