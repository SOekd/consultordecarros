package consultor.question.checkbox;

import consultor.question.QuestionConfigurationBuilder;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class CheckboxQuestionConfigurationBuilder<T extends Enum<T>> extends QuestionConfigurationBuilder {

    private Function<T, String> getDisplayName;

    private Supplier<List<T>> getValues;

    public CheckboxQuestionConfigurationBuilder<T> getDisplayName(Function<T, String> getDisplayName) {
        this.getDisplayName = getDisplayName;
        return this;
    }

    public CheckboxQuestionConfigurationBuilder<T> getValues(Supplier<List<T>> getValues) {
        this.getValues = getValues;
        return this;
    }

    @Override
    public CheckboxQuestionConfiguration build() {
        return new CheckboxQuestionConfiguration(
                question,
                errorMessages,
                key,
                variable,
                getDisplayName,
                getValues
        );
    }
}
