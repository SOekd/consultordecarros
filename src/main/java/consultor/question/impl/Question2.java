package consultor.question.impl;

import consultor.car.CarSize;
import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Question2 implements Question {

    private final List<CarSize> sizes = new ArrayList<>();

    @Override
    public void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers) {

        question.setText("Qual o porte do carro que você deseja?");

        answers.getChildren().clear();

        GridPane gridPane = new GridPane();
        var column = 0;
        var row = 0;
        gridPane.setHgap(10);

        for (CarSize value : CarSize.values()) {

            var checkBox = new CheckBox(value.getDisplayName());

            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    sizes.add(value);
                } else {
                    sizes.remove(value);
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

            if (sizes.isEmpty()) {
                view.displayError("Escolha ao menos um tipo!");
                return;
            }

            view.changePseudoCar(pseudoCar -> {
                pseudoCar.setSize(sizes);
            });

            view.invokeNextQuestion();
        });

    }

}
