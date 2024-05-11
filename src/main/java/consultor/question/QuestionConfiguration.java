package consultor.question;

import java.util.Map;

public abstract class QuestionConfiguration<T extends Question> {

    protected final String question;

    protected final Map<String, String> errorMessages;

    public QuestionConfiguration(String question, Map<String, String> errorMessages) {
        this.question = question;
        this.errorMessages = errorMessages;
    }

    public String getQuestion() {
        return question;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public abstract T getQuestionInstance();

}
