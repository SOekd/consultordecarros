package consultor.question;

import consultor.ui.QuestionView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public interface Question<T extends QuestionConfiguration> {

    void render(T configuration, QuestionView view, Text question, Button confirm, HBox answers);

}
