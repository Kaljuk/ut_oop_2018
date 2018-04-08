
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javafx.scene.*;

/**
 * Kalkulaator
 */
public class Kalkulaator extends Application {
    private String ratesFn = "rates.txt";
    private String currentOther = "GBP";
    //                              EEK    GBP  USD
    private String rateForEur   = "15.6466 0.8 1.2";
    private Double selectedRate = 0.8;

    public static void main(String[] args) {
        launch(args);    
    }

    
    @Override
    public void start(Stage stage) {
        getRates();

        Scene scene  = new Scene(new Group(), 450, 250);
        Canvas canvas= new Canvas(450, 250);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // Draw LOGO
        gc.setLineWidth(4.20);
        gc.setFill(Color.ROSYBROWN);
        gc.strokeOval(400, 200, 50, 50);
        gc.fillOval(400,200,50,50);
        
        gc.setFill(Color.RED);
        gc.strokeRect(385, 185, 45, 45);
        gc.fillRect(385,185,45,45);

        gc.setFill(Color.PEACHPUFF);
        gc.fillPolygon(new double[]{385,390,420}, new double[]{185,190,240}, 3);

        TextField eurField = new TextField ();
        TextField otherField = new TextField ();
        

        eurField.setPromptText("EUR");
        otherField.setPromptText(currentOther);
        eurField.setText("123");
        otherField.setText("123");
        eurField.clear();
        otherField.clear();

        eurField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            // 
            String converted = convertToOther(newValue);
            System.out.println(converted);
            //otherField.setPromptText(newValue);
        });
        otherField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println(newValue);
            
        });
        
        // CoiceBox
        ChoiceBox<String> otherCurrency = new ChoiceBox<String>();
        otherCurrency.getItems().addAll("GBP", "USD", "EEK");
        otherCurrency.setValue("GBP");

        otherCurrency.setOnAction(e -> changeOtherCurrency(otherCurrency, otherField));

        // Clear all fields button
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                clearTextFields(new TextField[]{eurField, otherField});
            }
        });


        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10);
        
        // Fields
        grid.add(eurField, 0, 0);
        grid.add(otherField, 0, 1);
        // ChoiceBox
        grid.add(otherCurrency, 1, 1);        

        // Place button
        grid.add(clearButton, 1, 0);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
    }
    
    // FX Functions
    private void clearTextFields(TextField[] fields) {
        for(int i=0; i<fields.length; i++) {
            fields[i].clear();            
        }
    }
    private void changeOtherCurrency(ChoiceBox<String> otherCurrency, TextField otherField) {
        String selectedCurrency = otherCurrency.getValue();
        currentOther = selectedCurrency;
        otherField.setPromptText(currentOther);
    }
    private String convertToOther(String toConvert) {
        String[] parts = toConvert.split("[.]|[,]");
        String doubleString = "";
        if (parts.length > 2 || parts.length < 0) {
            return "-";
        } else {
            if (parts.length > 1) {
                doubleString = parts[0].replaceAll("[^0-9]+","") + "." + parts[1].replaceAll("[^0-9]+","");
            } else {
                doubleString = parts[0].replaceAll("[^0-9]+","");
            }
        }
        if (doubleString.equals("")) {
            return "-";
        } else {
            return Double.toString( selectedRate * Double.parseDouble(doubleString) );
        }
    };

    private void getRates() {
        System.out.println("High rates");
    }
}