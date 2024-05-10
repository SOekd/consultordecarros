package consultor.question.impl;

import consultor.car.CarAspiration;
import consultor.car.CarConfiguration;
import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Question4 implements Question {

    private final List<CarAspiration> aspirations = new ArrayList<>();

    @Override
    public void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers) {

        question.setText("Qual aspiração que você deseja no carro?");

        answers.getChildren().clear();

        GridPane gridPane = new GridPane();
        var column = 0;
        var row = 0;
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        if (car.getAspiration() != null) {
            aspirations.addAll(car.getAspiration());
        }

        for (CarAspiration value : CarAspiration.values()) {

            var checkBox = new CheckBox(value.getDisplayName());

            if (aspirations.contains(value)) {
                checkBox.setSelected(true);
            }

            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    aspirations.add(value);
                } else {
                    aspirations.remove(value);
                }
            });

            gridPane.add(checkBox, column, row);
            if (row == 2) {
                row = 0;
                column++;
            } else {
                row++;
            }
        }

        answers.getChildren().add(gridPane);

        confirm.setOnAction(event -> {

            if (aspirations.isEmpty()) {
                view.displayError("Escolha ao menos uma aspiração!");
                return;
            }

            view.changePseudoCar(pseudoCar -> pseudoCar.setAspiration(aspirations));

            view.invokeNextQuestion();
        });

    }

}
