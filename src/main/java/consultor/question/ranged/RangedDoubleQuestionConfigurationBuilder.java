package consultor.question.ranged;

import consultor.car.PseudoCar;
import consultor.question.QuestionConfigurationBuilder;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RangedDoubleQuestionConfigurationBuilder extends QuestionConfigurationBuilder {

    private Function<PseudoCar, Double> getMaximum;

    private Function<PseudoCar, Double> getMinimum;

    private BiConsumer<PseudoCar, Double> setMaximum;

    private BiConsumer<PseudoCar, Double> setMinimum;

    public RangedDoubleQuestionConfigurationBuilder getMaximum(Function<PseudoCar, Double> supplier) {
        this.getMaximum = supplier;
        return this;
    }

    public RangedDoubleQuestionConfigurationBuilder getMinimum(Function<PseudoCar, Double> supplier) {
        this.getMinimum = supplier;
        return this;
    }

    public RangedDoubleQuestionConfigurationBuilder setMaximum(BiConsumer<PseudoCar, Double> consumer) {
        this.setMaximum = consumer;
        return this;
    }

    public RangedDoubleQuestionConfigurationBuilder setMinimum(BiConsumer<PseudoCar, Double> consumer) {
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
