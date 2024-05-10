package consultor.question.impl;

import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Question1 implements Question {

    @Override
    public void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers) {

        question.setText("Qual a faixa de preço que você deseja pagar?");

        answers.getChildren().clear();

        TextField minimum = new TextField();
        minimum.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                minimum.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        minimum.setPromptText("Mínimo");
        if (car.getMinimumPrice() != null) {
            minimum.setText(String.valueOf(car.getMinimumPrice()));
        }

        TextField maximum = new TextField();
        maximum.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                maximum.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        if (car.getMaximumPrice() != null) {
            maximum.setText(String.valueOf(car.getMaximumPrice()));
        }

        maximum.setPromptText("Máximo");

        confirm.setOnAction(event -> {

            var maximumText = maximum.getText();
            var minimumText = minimum.getText();

            if (maximumText.isEmpty() || minimumText.isEmpty()) {
                view.displayError("Preencha todos os campos");
                return;
            }

            var min = Double.parseDouble(minimumText);
            var max = Double.parseDouble(maximumText);

            if (min > max) {
                view.displayError("O valor mínimo não pode ser maior que o valor máximo");
                return;
            }

            view.changePseudoCar(pseudoCar -> {
                pseudoCar.setMinimumPrice(min);
                pseudoCar.setMaximumPrice(max);
            });

            view.invokeNextQuestion();
        });

        answers.getChildren().addAll(minimum, maximum);
    }

}
