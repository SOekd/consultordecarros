package consultor.question;


import consultor.car.*;
import consultor.question.checkbox.CheckboxQuestionConfigurationBuilder;
import consultor.shell.engine.EqualsClause;

import java.util.List;
import java.util.Locale;

public enum Questions {

    QUESTION_1(
            new CheckboxQuestionConfigurationBuilder<CarPriceCategory>()
                    .getDisplayName(CarPriceCategory::getDisplayName)
                    .getValues(() -> List.of(CarPriceCategory.values()))
                    .question("Qual é a faixa de preço do carro que você deseja?")
                    .key("price")
                    .build()
    ),
    QUESTION_2(
            new CheckboxQuestionConfigurationBuilder<CarSize>()
                    .getDisplayName(CarSize::getDisplayName)
                    .getValues(() -> List.of(CarSize.values()))
                    .question("Qual é o tamanho do carro que você deseja?")
                    .key("size")
                    .build()
    ),
    QUESTION_3(
            new CheckboxQuestionConfigurationBuilder<CarConfiguration>()
                    .getDisplayName(CarConfiguration::getDisplayName)
                    .getValues(() -> List.of(CarConfiguration.values()))
                    .question("Qual é a configuração do carro que você deseja?")
                    .key("configuration")
                    .build()
    ),
    QUESTION_4(
            new CheckboxQuestionConfigurationBuilder<CarAspiration>()
                    .getDisplayName(CarAspiration::getDisplayName)
                    .getValues(() -> List.of(CarAspiration.values()))
                    .question("Qual é a aspiração do carro que você deseja?")
                    .key("aspiration")
                    .build()
    ),
    QUESTION_5(
            new CheckboxQuestionConfigurationBuilder<CarFuelType>()
                    .getDisplayName(CarFuelType::getDisplayName)
                    .getValues(() -> List.of(CarFuelType.values()))
                    .question("Qual é o tipo de combustível do carro que você deseja?")
                    .key("fuelType")
                    .build()
    ),
    QUESTION_6(
            new CheckboxQuestionConfigurationBuilder<CarTransmission>()
                    .getDisplayName(CarTransmission::getDisplayName)
                    .getValues(() -> List.of(CarTransmission.values()))
                    .question("Qual é o tipo de transmissão do carro que você deseja?")
                    .key("transmission")
                    .build()
    ),
    QUESTION_7(
            new CheckboxQuestionConfigurationBuilder<CarSteeringType>()
                    .getDisplayName(CarSteeringType::getDisplayName)
                    .getValues(() -> List.of(CarSteeringType.values()))
                    .question("Qual é o tipo de direção do carro que você deseja?")
                    .key("steeringType")
                    .build()
    ),
    QUESTION_8(
            new CheckboxQuestionConfigurationBuilder<CarTraction>()
                    .getDisplayName(CarTraction::getDisplayName)
                    .getValues(() -> List.of(CarTraction.values()))
                    .question("Qual é o tipo de tração do carro que você deseja?")
                    .key("traction")
                    .build()
    ),
    QUESTION_9(
            new CheckboxQuestionConfigurationBuilder<CarPropulsion>()
                    .getDisplayName(CarPropulsion::getDisplayName)
                    .getValues(() -> List.of(CarPropulsion.values()))
                    .question("Qual é o tipo de propulsão do carro que você deseja?")
                    .key("propulsion")
                    .build()
    ),
    QUESTION_10(
            new CheckboxQuestionConfigurationBuilder<CarOrigin>()
                    .getDisplayName(CarOrigin::getDisplayName)
                    .getValues(() -> List.of(CarOrigin.values()))
                    .question("Qual é a origem do carro que você deseja?")
                    .key("origin")
                    .build()
    ),
QUESTION_11(
            new CheckboxQuestionConfigurationBuilder<CarSeatType>()
                    .getDisplayName(CarSeatType::getDisplayName)
                    .getValues(() -> List.of(CarSeatType.values()))
                    .question("Qual é o tipo de assento do carro que você deseja?")
                    .key("seatType")
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
