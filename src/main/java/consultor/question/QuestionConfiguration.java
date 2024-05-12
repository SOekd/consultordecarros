package consultor.question;

import java.util.Map;

public abstract class QuestionConfiguration<T extends Question> {

    protected final String question;

    protected final Map<String, String> errorMessages;

    protected final String key;

    protected final String variable;

    protected QuestionConfiguration(String question, Map<String, String> errorMessages, String key, String variable) {
        this.question = question;
        this.errorMessages = errorMessages;
        this.key = key;
        this.variable = variable;
    }

    public String getQuestion() {
        return question;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public String getVariable() {
        return variable;
    }

    public String getKey() {
        return key;
    }

    public abstract T getQuestionInstance();

}
