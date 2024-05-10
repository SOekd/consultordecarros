package consultor.question.impl;

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

public class Question3 implements Question {

    private final List<CarConfiguration> configurations = new ArrayList<>();

    @Override
    public void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers) {

        question.setText("Qual a configuração do carro que deseja?");

        answers.getChildren().clear();

        GridPane gridPane = new GridPane();
        var column = 0;
        var row = 0;
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        if (car.getConfiguration() != null) {
            configurations.addAll(car.getConfiguration());
        }

        for (CarConfiguration value : CarConfiguration.values()) {

            var checkBox = new CheckBox(value.getDisplayName());

            if (configurations.contains(value)) {
                checkBox.setSelected(true);
            }

            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    configurations.add(value);
                } else {
                    configurations.remove(value);
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

            if (configurations.isEmpty()) {
                view.displayError("Escolha ao menos uma configuração!");
                return;
            }

            view.changePseudoCar(pseudoCar -> pseudoCar.setConfiguration(configurations));

            view.invokeNextQuestion();
        });

    }

}
