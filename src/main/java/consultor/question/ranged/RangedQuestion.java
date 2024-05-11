package consultor.question.ranged;

import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.question.QuestionConfiguration;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.function.Consumer;

public class RangedQuestion implements Question {

    public static final String MESSAGE_EMPTY = "empty";
    public static final String MESSAGE_MIN_GREATER_THAN_MAX = "min_greater_than_max";

    @Override
    public void render(
            QuestionConfiguration<?> rawConfiguration,
            PseudoCar car,
            QuestionView view,
            Text question,
            Button confirm,
            HBox answers,
            Consumer<Void> finished
            ) {
        RangedDoubleQuestionConfiguration configuration = (RangedDoubleQuestionConfiguration) rawConfiguration;


        question.setText(configuration.getQuestion());

        answers.getChildren().clear();

        TextField minimum = new TextField();
        minimum.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                minimum.setText(oldValue);
            }
        });
        minimum.setPromptText("Mínimo");
        if (configuration.getGetMinimum().apply(car) != null) {
            minimum.setText(String.valueOf(configuration.getGetMinimum().apply(car)));
        }

        TextField maximum = new TextField();
        maximum.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                maximum.setText(oldValue);
            }
        });

        if (configuration.getGetMaximum().apply(car) != null) {
            maximum.setText(String.valueOf(configuration.getGetMaximum().apply(car)));
        }

        maximum.setPromptText("Máximo");

        confirm.setOnAction(event -> {

            var maximumText = maximum.getText();
            var minimumText = minimum.getText();

            if (maximumText.isEmpty() || minimumText.isEmpty()) {
                view.displayError(configuration.getErrorMessages().getOrDefault(MESSAGE_EMPTY, "Preencha todos os campos"));
                return;
            }

            var min = Double.parseDouble(minimumText);
            var max = Double.parseDouble(maximumText);

            if (min > max) {
                view.displayError(configuration.getErrorMessages().getOrDefault(MESSAGE_MIN_GREATER_THAN_MAX, "O valor mínimo deve ser menor que o valor máximo"));
                return;
            }

            System.out.println("HERADASDA");
            view.changePseudoCar(pseudoCar -> {
                configuration.getSetMaximum().accept(car, max);
                configuration.getSetMinimum().accept(car, min);
            });

            if (!view.invokeNextQuestion()) {

            }
        });

        answers.getChildren().addAll(minimum, maximum);
    }

}
