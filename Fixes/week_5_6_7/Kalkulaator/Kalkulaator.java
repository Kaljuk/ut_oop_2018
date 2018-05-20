
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

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
    // File that the currencies and their rate to main currency is (at the moment it is eur)
    //private String ratesFn = "rate2s.txt";
    private String ratesFn = "rates.txt";

    // Main currency that cannot be changed
    private String mainCurrency     = "EUR";
    // Other currency that main currency will be converted to
    private String convertTargetCurrency = "EUR";
    // All currencies and their values
    private HashMap<String, Double> currencyRates = new HashMap<String, Double>(); 

    public static void main(String[] args) {
        launch(args);    
    }

    
    @Override
    public void start(Stage stage) {
        
        // Add currencies from the file
        try {
            currencyRates = getRates(ratesFn);
        } catch(Exception e) {
            System.out.println(e);
            System.exit(0);
        }

        Scene scene  = new Scene(new Group(), 450, 250);
        Canvas canvas= new Canvas(450, 250);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawLogo(gc);

        TextField eurField = new TextField ();
        TextField otherField = new TextField ();
        

        eurField.setPromptText("EUR");
        otherField.setPromptText(convertTargetCurrency);
        eurField.setText("0.0");
        otherField.setText("0.0");
        eurField.clear();
        otherField.clear();

        otherField.setEditable(false);
        
        // CoiceBox
        ChoiceBox<String> otherCurrency = new ChoiceBox<String>();
        for(String c : currencyRates.keySet()) {
            otherCurrency.getItems().add(c);
            otherCurrency.setValue(c);
        }
        // otherCurrency.getItems().addAll("GBP", "USD", "EEK");
        // otherCurrency.setValue("GBP");


        // (observable, oldValue, newValue)
        eurField.textProperty().addListener( e -> changeOtherCurrency(otherCurrency, eurField, otherField) );

        otherCurrency.setOnAction(e -> changeOtherCurrency(otherCurrency, eurField, otherField));

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
        root.getChildren().add(canvas);
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
    
    //Draw logo
    private void drawLogo(GraphicsContext gc) {
        // Draw LOGO
        gc.setLineWidth(4.20);
        gc.setFill(Color.ROSYBROWN);
        gc.strokeOval(400, 200, 50, 50);
        gc.fillOval(400,200,50,50);
        
        gc.setFill(Color.RED);
        gc.strokeRect(385, 185, 45, 45);
        gc.fillRect(385,185,45,45);

        gc.setFill(Color.PEACHPUFF);
        gc.fillPolygon(new double[]{450,420,390}, new double[]{250,190,240}, 3);
    }

    // FX Functions
    private void clearTextFields(TextField[] fields) {
        for(TextField field: fields) {
            field.clear();
        }
    }

    // Change the other Currency box value
    private void changeOtherCurrency(ChoiceBox otherCurrency, TextField mainCurrencyField, TextField otherField) {
        // currencyRates.get(targetCurrency) * mainCurrency.getText()
        Double convertedCurrency = convertToOtherCurrency(mainCurrencyField.getText(), otherCurrency.getValue().toString());
        otherField.setPromptText( new DecimalFormat(".##").format( convertedCurrency ) ); // .toString()
    }

    private Double convertToOtherCurrency(String stringToDouble, String targetCurrency) {
        String[] parts = stringToDouble.split("[.,]");
        String doubleString = "";
        
        if (parts.length > 2 || parts.length < 0) {
            return Double.NaN;
        } else {
            if (parts.length > 1) {
                doubleString = parts[0].replaceAll("[^0-9]+","") + "." + parts[1].replaceAll("[^0-9]+","");
            } else {
                doubleString = parts[0].replaceAll("[^0-9]+","");
            }
        }
        if (doubleString.equals("") || currencyRates.get(targetCurrency) == null) {
            return Double.NaN;
        } else {
            
            return currencyRates.get(targetCurrency) * Double.parseDouble(doubleString);
        }
    };

    // Get currency rates from the txt file
    private HashMap<String, Double> getRates(String fn) throws IOException {
        // Save names here
        HashMap<String, Double> currencies = new HashMap<String, Double>();
        InputStream inputStream;
        BufferedReader failiSisu;

        try {
            inputStream = new FileInputStream(new File(fn));
            // Ei kasuta fileReaderit ning saab kodeeringut valida
            failiSisu = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            // Get file contents
            String failiRida;
            String currencyName;
            Double currencyRate;
            while((failiRida= failiSisu.readLine()) != null) {
                try {
                    currencyName = failiRida.split(" ")[0];
                    currencyRate = Double.valueOf( failiRida.split(" ")[1] );
                    currencies.put(currencyName, currencyRate);
                    // Remove all unprintable characters
                    currencyName = currencyName.replaceAll("\\p{C}", "");
                    System.out.println(String.format("Found currency %s %.4f", currencyName, currencyRate));
                } catch(Exception e) {
                    System.out.println("Failed to add currency"+e.toString());
                }
            }
        
            // Close the buffer
            failiSisu.close();
            
        } catch(FileNotFoundException e) {
            System.out.println(e);
            System.out.println("Currencies file not found, cannot find the file to read currencies from: "+ratesFn);
            System.exit(0);
        }

        // Return found currencies
        return currencies;
    }
}
