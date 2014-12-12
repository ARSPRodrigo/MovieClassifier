package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button btnClear;
    public TextArea plotArea;
    public Button btnFind;
    public Label resultLabel;
    public String text;

    /*
     * global variables containing
     * files use in th code
     */
    static String file = "plot.txt";        // the plot to find type
    private static String version;          // CSV file which has the document term matrix

    static {
        version = "version.csv";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                plotArea.clear();
                resultLabel.setText("");
            }
        });

        btnFind.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text = plotArea.getText();
                try {
                    CreateMatrices.createWordMatrix(version);
                    CreateMatrices.newPlot(file, text);
                    CreateMatrices.newPlotMatrix();
                    resultLabel.setText(KNN.Main(CreateMatrices.exNewWordMatrix, CreateMatrices.movieInstances, CreateMatrices.exWordCountMatrix));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
