package consultor.question;

import consultor.car.PseudoCar;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.function.Consumer;

public interface Question {

    void render(QuestionConfiguration<?> configuration, PseudoCar car, QuestionView view, Text question, Button confirm, HBox answers, Consumer<Void> finished);

}
