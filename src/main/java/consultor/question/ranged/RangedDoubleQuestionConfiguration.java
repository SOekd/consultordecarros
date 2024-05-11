package consultor.question.ranged;

import consultor.car.PseudoCar;
import consultor.question.QuestionConfiguration;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RangedDoubleQuestionConfiguration extends QuestionConfiguration<RangedQuestion> {

    private final Function<PseudoCar, Double> getMaximum;

    private final Function<PseudoCar, Double> getMinimum;

    private final BiConsumer<PseudoCar, Double> setMaximum;

    private final BiConsumer<PseudoCar, Double> setMinimum;

    public RangedDoubleQuestionConfiguration(String question, Map<String, String> errorMessages, Function<PseudoCar, Double> getMaximum, Function<PseudoCar, Double> getMinimum, BiConsumer<PseudoCar, Double> setMaximum, BiConsumer<PseudoCar, Double> setMinimum) {
        super(question, errorMessages);
        this.getMaximum = getMaximum;
        this.getMinimum = getMinimum;
        this.setMaximum = setMaximum;
        this.setMinimum = setMinimum;
    }

    public Function<PseudoCar, Double> getGetMaximum() {
        return getMaximum;
    }

    public Function<PseudoCar, Double> getGetMinimum() {
        return getMinimum;
    }

    public BiConsumer<PseudoCar, Double> getSetMaximum() {
        return setMaximum;
    }

    public BiConsumer<PseudoCar, Double> getSetMinimum() {
        return setMinimum;
    }

    @Override
    public RangedQuestion getQuestionInstance() {
        return new RangedQuestion();
    }
}
