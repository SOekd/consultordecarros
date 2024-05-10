package consultor.question.ranged;

import consultor.question.QuestionConfigurationBuilder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RangedDoubleQuestionConfigurationBuilder extends QuestionConfigurationBuilder {

    private Supplier<Double> getMaximum;

    private Supplier<Double> getMinimum;

    private Consumer<Double> setMaximum;

    private Consumer<Double> setMinimum;

    public RangedDoubleQuestionConfigurationBuilder getMaximum(Supplier<Double> supplier) {
        this.getMaximum = supplier;
        return this;
    }

    public RangedDoubleQuestionConfigurationBuilder getMinimum(Supplier<Double> supplier) {
        this.getMinimum = supplier;
        return this;
    }

    public RangedDoubleQuestionConfigurationBuilder setMaximum(Consumer<Double> consumer) {
        this.setMaximum = consumer;
        return this;
    }

    public RangedDoubleQuestionConfigurationBuilder setMinimum(Consumer<Double> consumer) {
        this.setMinimum = consumer;
        return this;
    }

    @Override
    public RangedDoubleQuestionConfiguration build() {
        return new RangedDoubleQuestionConfiguration(
            question,
            errorMessages,
            getMaximum,
            getMinimum,
            setMaximum,
            setMinimum
        );
    }

}
