package consultor.question.impl;

import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Question6 implements Question {

    @Override
    public void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers) {

        question.setText("Qual a faixa de consumo que você desejaria no carro? (Em km/l)");

        answers.getChildren().clear();

        TextField minimum = new TextField();
        minimum.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.isBlank())
                    return;
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                minimum.setText(oldValue);
            }
        });
        minimum.setPromptText("Mínimo");
        if (car.getMinimumConsumption() != null) {
            minimum.setText(String.valueOf(car.getMinimumConsumption()));
        }

        TextField maximum = new TextField();
        maximum.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.isEmpty())
                    return;
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                maximum.setText(oldValue);
            }
        });

        if (car.getMaximumConsumption() != null) {
            maximum.setText(String.valueOf(car.getMaximumConsumption()));
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
                pseudoCar.setMinimumConsumption(min);
                pseudoCar.setMaximumConsumption(max);
            });

            view.invokeNextQuestion();
        });

        answers.getChildren().addAll(minimum, maximum);
    }

}
