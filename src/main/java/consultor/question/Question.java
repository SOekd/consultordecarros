package consultor.question;

import consultor.car.PseudoCar;
import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public interface Question {

    void render(QuestionView view, PseudoCar car, Text question, Button confirm, HBox answers);

}
