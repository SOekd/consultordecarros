package consultor.question;

import consultor.question.ui.QuestionView;
import consultor.shell.engine.Clause;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.List;

public interface Question {

    void render(QuestionConfiguration<?> configuration,
                QuestionView view,
                Text question,
                Button confirm,
                HBox answers,
                List<Clause> clauses
    );

}
