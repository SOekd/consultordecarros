package consultor.ui;

import atlantafx.base.theme.Styles;
import consultor.car.Car;
import consultor.car.PseudoCar;
import consultor.question.Question;
import consultor.question.Questions;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.javafx.FontIcon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class QuestionView extends Scene {

    private final List<Car> cars;

    private Text questionText = new Text("Qual o tamanho do carro? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    private int currentQuestion = 0;

    private HBox answers = new HBox();

    private PseudoCar pseudoCar = new PseudoCar();

    private Button confirmButton = new Button("Confirmar", new FontIcon(Feather.CHECK));

    private Button backButton = new Button("Voltar", new FontIcon(Feather.ARROW_LEFT));

    private final VBox root;

    public QuestionView(VBox root, List<Car> cars) {
        super(root, 600, 400);
        this.root = root;
        this.cars = cars;

        questionText.getStyleClass().add(Styles.TITLE_3);
        questionText.setWrappingWidth(500);
        root.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(questionText, new Insets(20));
        VBox.setMargin(answers, new Insets(50));
        questionText.setTextAlignment(TextAlignment.CENTER);

        if (!invokeNextQuestion()) {
            System.out.println("NAO FOI");
        }

        answers.setAlignment(Pos.CENTER);
        answers.setSpacing(20);

        confirmButton.getStyleClass().add(Styles.SUCCESS);
        backButton.getStyleClass().add(Styles.DANGER);

        HBox buttonBox = new HBox(backButton, confirmButton);

        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);

        backButton.setOnAction(event -> {
            if (currentQuestion > 1) {
                currentQuestion -= 2;
                invokeNextQuestion();
            } else {
                displayError("Não é possível voltar mais");
            }

        });

        root.getChildren().addAll(questionText, answers, buttonBox);
    }

    public boolean invokeNextQuestion() {
        currentQuestion++;

        return Arrays.stream(Questions.values())
                    .filter(it -> it.name().endsWith("_" + currentQuestion))
                    .findAny()
                .map(it -> {
                    var configuration = it.getConfiguration();

                    configuration.getQuestionInstance().render(configuration, pseudoCar, this, questionText, confirmButton, answers);
                    return true;
                })
                .orElse(false);
//            question.render(this, pseudoCar, questionText, confirmButton, answers);
    }

    public void changePseudoCar(Consumer<PseudoCar> consumer) {
        consumer.accept(pseudoCar);
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
