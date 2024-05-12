package consultor.question.ui;

import atlantafx.base.theme.Styles;
import consultor.car.Car;
import consultor.question.Questions;
import consultor.shell.engine.Clause;
import consultor.shell.engine.EqualsClause;
import consultor.shell.engine.KieRuleInferenceEngine;
import consultor.shell.engine.RuleInferenceEngine;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;

public class QuestionView extends Scene {

    private final List<Car> cars;

    private Text questionText = new Text("Qual o tamanho do carro? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    private HBox answers = new HBox();

    private Button confirmButton = new Button("Confirmar", new FontIcon(Feather.CHECK));

    private Button backButton = new Button("Recomeçar", new FontIcon(Feather.ARROW_LEFT));

    private final RuleInferenceEngine engine;

    private final VBox root;

    public QuestionView(RuleInferenceEngine engine, VBox root, List<Car> cars) {
        super(root, 600, 400);
        this.engine = engine;
        this.root = root;
        this.cars = cars;

        questionText.getStyleClass().add(Styles.TITLE_3);
        questionText.setWrappingWidth(500);
        root.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(questionText, new Insets(20));
        VBox.setMargin(answers, new Insets(50));
        questionText.setTextAlignment(TextAlignment.CENTER);

        invokeNextQuestion();

        answers.setAlignment(Pos.CENTER);
        answers.setSpacing(20);

        confirmButton.getStyleClass().add(Styles.SUCCESS);
        backButton.getStyleClass().add(Styles.DANGER);

        HBox buttonBox = new HBox(backButton, confirmButton);

        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);

        backButton.setOnAction(event -> {
            engine.clearFacts();

            invokeNextQuestion();
        });

        root.getChildren().addAll(questionText, answers, buttonBox);
    }

    public void invokeNextQuestion() {
        Vector<Clause> unprovedConditions = new Vector<>();

        Clause conclusion = engine.infer("vehicle", unprovedConditions);

        if (conclusion == null) {
            if (unprovedConditions.isEmpty()) {
                handleFinish(null);
                return;
            }


            String lastValue = null;
            boolean multipleValues = false;
            for (Clause unprovedCondition : unprovedConditions) {
                System.out.println("Clause:" + unprovedCondition.getVariable() + " " + unprovedCondition.getCondition() + " " + unprovedCondition.getValue());
                if (lastValue == null) {
                    lastValue = unprovedCondition.getValue();
                } else if (!lastValue.equals(unprovedCondition.getValue())) {
                    multipleValues = true;
                    break;
                }
            }


            Clause clause = unprovedConditions.get(0);

            if (!multipleValues) {
                engine.addFact(new EqualsClause(clause.getVariable(), lastValue));
                invokeNextQuestion();
                return;
            }

            var question = Arrays.stream(Questions.values())
                    .filter(it -> it.getConfiguration().getKey().equalsIgnoreCase(clause.getVariable()))
                    .findAny();

            if (question.isEmpty()) {
                displayError("Não foi possível encontrar a questão para a variável " + clause.getVariable());
                handleFinish(null);
                return;
            }

            var configuration = question.get().getConfiguration();

            configuration.getQuestionInstance().render(
                    configuration,
                    this,
                    questionText,
                    confirmButton,
                    answers,
                    unprovedConditions
            );
        } else {

            Car car = cars.stream()
                    .filter(it -> it.getModel().equalsIgnoreCase(conclusion.getValue()))
                    .findAny()
                    .orElse(null);

            handleFinish(car);
        }

    }

    private void handleFinish(Car car) {

        if (car == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.initOwner(root.getScene().getWindow());
            alert.setTitle("Carro desconhecido");
            alert.setHeaderText(null);
            alert.setContentText("Não foi possível determinar o carro! Tente com outras opções.");

            alert.setOnCloseRequest(event -> {
                engine.clearFacts();
                invokeNextQuestion();
            });
            return;
        }

        var alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.initOwner(root.getScene().getWindow());
        alert.setTitle("Carro determinado");
        alert.setHeaderText(null);
        alert.setContentText("O carro é um " + car.getModel() + "!");

        alert.setOnCloseRequest(event -> {
            engine.clearFacts();
            invokeNextQuestion();
        });

        alert.show();
    }

    public RuleInferenceEngine getEngine() {
        return engine;
    }


    public void displayError(String content) {
        var alert = new Alert(Alert.AlertType.ERROR);

        alert.initOwner(root.getScene().getWindow());
        alert.setTitle("Erro");
        alert.setHeaderText("Erro");
        alert.setContentText(content);
        alert.show();
    }


}
