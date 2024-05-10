package consultor.question;

import consultor.question.ranged.RangedDoubleQuestionConfigurationBuilder;
import consultor.question.ranged.RangedQuestion;

public enum Questions {

    QUESTION_1(
            new RangedDoubleQuestionConfigurationBuilder()
                    .question("Qual a faixa de valor do carro que você deseja?")
                    .getGet
                    .build()
    );

    private final QuestionConfiguration<?> configuration;

    Questions(QuestionConfiguration<?> configuration) {
        this.configuration = configuration;
    }

    public QuestionConfiguration getConfiguration() {
        return configuration;
    }

}
