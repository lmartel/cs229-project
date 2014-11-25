package Project;

import Project.Features.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinearRegression implements RegressionAlgorithm {

    private final List<Feature> features;

    public LinearRegression(List<Feature> features){
        this.features = features;
    }

    @Override
    public void train(List<Comment> trainingData) {
        System.out.println("Training linear regression on " + trainingData.size() + " comments...");
        IO.writeInputFile(Constants.LINEAR_REGRESSION_TRAIN_FILENAME, new FeatureFormatter(features), trainingData);
        IO.runPython(Constants.LINEAR_REGRESSION_FEATURES_TRAIN);
    }

    @Override
    public double predict(Comment comment) {
        List<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        return predict(comments).get(comment);
    }

    @Override
    public Map<Comment, Double> predict(List<Comment> comments) {
        System.out.println("Testing linear regression on " + comments.size() + " comments...");
        IO.writeInputFile(Constants.LINEAR_REGRESSION_TEST_FILENAME, new FeatureFormatter(features), comments);
        IO.runPython(Constants.LINEAR_REGRESSION_FEATURES_TEST);
        return IO.readRegressionOutputFile(Constants.LINEAR_REGRESSION_PREDICTION_FILENAME, comments);
    }


}
