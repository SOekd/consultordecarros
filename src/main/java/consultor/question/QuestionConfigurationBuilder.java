package consultor.question;

import java.util.HashMap;
import java.util.Map;

public abstract class QuestionConfigurationBuilder {

    protected String question;

    protected Map<String, String> errorMessages = new HashMap<>();

    public QuestionConfigurationBuilder question(String question) {
        this.question = question;
        return this;
    }

    public QuestionConfigurationBuilder errorMessage(String key, String message) {
        errorMessages.put(key, message);
        return this;
    }

    public abstract QuestionConfiguration build();

}
