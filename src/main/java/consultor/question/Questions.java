package consultor.question;

import consultor.car.PseudoCar;
import consultor.question.ranged.RangedDoubleQuestionConfigurationBuilder;

public enum Questions {

    QUESTION_1(
            new RangedDoubleQuestionConfigurationBuilder()
                    .getMinimum(PseudoCar::getMinimumPrice)
                    .getMaximum(PseudoCar::getMaximumPrice)
                    .setMaximum(PseudoCar::setMaximumPrice)
                    .setMinimum(PseudoCar::setMinimumPrice)
                    .question("Qual o preço mínimo e máximo que você deseja?")
                    .build()
    );

    private final QuestionConfiguration<?> configuration;

    Questions(QuestionConfiguration<?> configuration) {
        this.configuration = configuration;
    }

    public QuestionConfiguration<?> getConfiguration() {
        return configuration;
    }

}
