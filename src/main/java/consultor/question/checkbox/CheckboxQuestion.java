package consultor.question.checkbox;

import consultor.car.Car;
import consultor.question.Question;
import consultor.question.QuestionConfiguration;
import consultor.question.ui.QuestionView;
import consultor.shell.engine.Clause;
import consultor.shell.engine.EqualsClause;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;


public class CheckboxQuestion<T extends Enum<T>> implements Question {

    public static final String MESSAGE_EMPTY = "empty";
    public static final String MESSAGE_MIN_GREATER_THAN_MAX = "min_greater_than_max";

    private T option = null;

    @Override
    public void render(
            QuestionConfiguration<?> rawConfiguration,
            QuestionView view,
            Text question,
            Button confirm,
            HBox answers,
            List<Clause> clauses
    ) {
        CheckboxQuestionConfiguration<T> configuration;
        try {
            configuration = (CheckboxQuestionConfiguration<T>) rawConfiguration;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Invalid configuration type provided to CheckboxQuestion", e);
        }
        question.setText(configuration.getQuestion());

        answers.getChildren().clear();

        var group = new ToggleGroup();

        VBox select = new VBox();
        for (T value : configuration.getGetValues().get()
                .stream()
                .filter(it -> clauses.stream().anyMatch(clause -> clause.getValue().equalsIgnoreCase(it.name())))
                .toList()
        ) {
            var checkBox = new RadioButton(configuration.getGetDisplayName().apply(value));

            checkBox.setToggleGroup(group);

            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    option = value;
                    System.out.println("Selected: " + value);
                }
            });

            select.getChildren().add(checkBox);
        }

        answers.getChildren().add(select);

        var clause = clauses.get(0);

        confirm.setOnAction(event -> {
            System.out.println("Selected2: " + option);
            if (option == null) {
                view.displayError(configuration.getErrorMessages().getOrDefault(MESSAGE_EMPTY, "Selecione uma opção"));
                return;
            }

            view.getEngine().addFact(new EqualsClause(clause.getVariable(), option.name().toLowerCase(Locale.ROOT)));

            view.invokeNextQuestion();
        });

    }
}