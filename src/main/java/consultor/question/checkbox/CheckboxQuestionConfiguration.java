package consultor.question.checkbox;

import consultor.question.QuestionConfiguration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class CheckboxQuestionConfiguration<T extends Enum<T>> extends QuestionConfiguration<CheckboxQuestion<?>> {

    private final Function<T, String> getDisplayName;

    private final Supplier<List<T>> getValues;

    public CheckboxQuestionConfiguration(String question, Map<String, String> errorMessages, String key, String variable, Function<T, String> getDisplayName, Supplier<List<T>> getValues) {
        super(question, errorMessages, key, variable);
        this.getDisplayName = getDisplayName;
        this.getValues = getValues;
    }

    public Function<T, String> getGetDisplayName() {
        return getDisplayName;
    }

    public Supplier<List<T>> getGetValues() {
        return getValues;
    }

    @Override
    public CheckboxQuestion getQuestionInstance() {
        return new CheckboxQuestion();
    }
}