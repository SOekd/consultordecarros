package consultor.question.ranged;

import consultor.question.QuestionConfiguration;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RangedDoubleQuestionConfiguration extends QuestionConfiguration<RangedQuestion> {

    private final Supplier<Double> getMaximum;

    private final Supplier<Double> getMinimum;

    private final Consumer<Double> setMaximum;

    private final Consumer<Double> setMinimum;

    public RangedDoubleQuestionConfiguration(String question, Map<String, String> errorMessages, Supplier<Double> getMaximum, Supplier<Double> getMinimum, Consumer<Double> setMaximum, Consumer<Double> setMinimum) {
        super(question, errorMessages);
        this.getMaximum = getMaximum;
        this.getMinimum = getMinimum;
        this.setMaximum = setMaximum;
        this.setMinimum = setMinimum;
    }

    public Supplier<Double> getGetMaximum() {
        return getMaximum;
    }

    public Supplier<Double> getGetMinimum() {
        return getMinimum;
    }

    public Consumer<Double> getSetMaximum() {
        return setMaximum;
    }

    public Consumer<Double> getSetMinimum() {
        return setMinimum;
    }

    @Override
    public RangedQuestion getQuestionInstance() {
        return new RangedQuestion();
    }
}
