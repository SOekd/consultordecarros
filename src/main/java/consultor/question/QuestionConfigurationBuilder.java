package consultor.question;

import java.util.HashMap;
import java.util.Map;

public abstract class QuestionConfigurationBuilder {

    protected String question;

    protected Map<String, String> errorMessages = new HashMap<>();

    protected String key;

    protected String variable;

    public QuestionConfigurationBuilder question(String question) {
        this.question = question;
        return this;
    }

    public QuestionConfigurationBuilder errorMessage(String key, String message) {
        errorMessages.put(key, message);
        return this;
    }

    public QuestionConfigurationBuilder key(String key) {
        this.key = key;
        return this;
    }

    public QuestionConfigurationBuilder variable(String variable) {
        this.variable = variable;
        return this;
    }

    public abstract QuestionConfiguration build();

}
