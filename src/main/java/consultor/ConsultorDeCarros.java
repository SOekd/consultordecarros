package consultor;

import atlantafx.base.theme.PrimerDark;
import consultor.car.*;
import consultor.question.ui.QuestionView;
import consultor.shell.engine.*;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.dhatim.fastexcel.reader.Cell;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

public class ConsultorDeCarros extends Application {

    private final List<Car> cars = new ArrayList<>();

    private final RuleInferenceEngine ruleInferenceEngine = new KieRuleInferenceEngine();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        parseCar();

        startInferenceEngine();

        VBox root = new VBox();

        primaryStage.setScene(new QuestionView(ruleInferenceEngine, root, cars));

        primaryStage.show();
    }

    private void startInferenceEngine() {

        for (Car car : cars) {
            Rule rule = new Rule(car.getModel());

            rule.addAntecedent(new EqualsClause("price", CarPriceCategory.fromPrice(car.getPrice()).name().toLowerCase(Locale.ROOT)));
            rule.addAntecedent(new EqualsClause("seatType", car.getSeatType().name().toLowerCase(Locale.ROOT)));
            rule.addAntecedent(new EqualsClause("propulsion", car.getPropulsion().name().toLowerCase(Locale.ROOT)));
            rule.addAntecedent(new EqualsClause("origin", car.getOrigin().name().toLowerCase(Locale.ROOT)));

            rule.addAntecedent(new EqualsClause("transmission", car.getTransmission().name().toLowerCase(Locale.ROOT)));

            rule.addAntecedent(new EqualsClause("configuration", car.getConfiguration().name().toLowerCase(Locale.ROOT)));


            rule.addAntecedent(new EqualsClause("fuelType", car.getFuelType().name().toLowerCase(Locale.ROOT)));
            rule.addAntecedent(new EqualsClause("transmission", car.getTransmission().name().toLowerCase(Locale.ROOT)));
            rule.addAntecedent(new EqualsClause("steeringType", car.getSteeringType().name().toLowerCase(Locale.ROOT)));
            rule.addAntecedent(new EqualsClause("traction", car.getTraction().name().toLowerCase(Locale.ROOT)));

            rule.addAntecedent(new EqualsClause("size", car.getSize().name().toLowerCase(Locale.ROOT)));

            rule.addAntecedent(new EqualsClause("aspiration", car.getAspiration().name().toLowerCase(Locale.ROOT)));


            rule.setConsequent(new EqualsClause("vehicle", car.getModel()));

            ruleInferenceEngine.addRule(rule);
        }

    }


    private void parseCar() {
        cars.clear();
        readExcel().values().stream().skip(1).forEach((columns) -> {

            Car car = new Car(
                    columns.get(0),
                    Double.parseDouble(columns.get(1)),
                    CarSize.findByDisplayName(columns.get(2)),
                    CarConfiguration.findByDisplayName(columns.get(3)),
                    CarAspiration.findByDisplayName(columns.get(4)),
                    Double.parseDouble(columns.get(5)),
                    Double.parseDouble(columns.get(6)),
                    Double.parseDouble(columns.get(7)),
                    CarFuelType.findByDisplayName(columns.get(8)),
                    CarTransmission.findByDisplayName(columns.get(9)),
                    CarSteeringType.findByDisplayName(columns.get(10)),
                    CarTraction.findByDisplayName(columns.get(11)),
                    CarPropulsion.findByDisplayName(columns.get(12)),
                    Integer.parseInt(columns.get(13).replace(".0", "")),
                    Integer.parseInt(columns.get(14).replace(".0", "")),
                    Integer.parseInt(columns.get(15).replace(".0", "")),
                    CarOrigin.findByDisplayName(columns.get(16)),
                    CarSeatType.findByDisplayName(columns.get(18))
            );

            cars.add(car);
        });

        cars.forEach(System.out::println);

    }


    public static Map<Integer, List<String>> readExcel() {
        Map<Integer, List<String>> data = new HashMap<>();


        try (InputStream file = ConsultorDeCarros.class.getClassLoader().getResourceAsStream("carros.xlsx")
             ; ReadableWorkbook wb = new ReadableWorkbook(file)) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    data.put(r.getRowNum(), new ArrayList<>());

                    for (Cell cell : r) {
                        data.get(r.getRowNum()).add(cell.getRawValue());
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

}
