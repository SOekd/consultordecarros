package consultor.question.impl;

import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Question5 implements Question {

    @Override
    public void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers) {

        question.setText("Qual a faixa de autonomia que vocë desejaria no carro? (Em km)");

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
        if (car.getMinimumAutonomy() != null) {
            minimum.setText(String.valueOf(car.getMinimumAutonomy()));
        }

        TextField maximum = new TextField();
        maximum.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                maximum.setText(oldValue);
            }
        });

        if (car.getMaximumAutonomy() != null) {
            maximum.setText(String.valueOf(car.getMaximumAutonomy()));
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
                pseudoCar.setMinimumAutonomy(min);
                pseudoCar.setMaximumAutonomy(max);
            });

            view.invokeNextQuestion();
        });

        answers.getChildren().addAll(minimum, maximum);
    }

}
