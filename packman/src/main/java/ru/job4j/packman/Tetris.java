package ru.job4j.packman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class Tetris extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane canvas = new BorderPane();
        Scene scene = new Scene(canvas, 500, 500);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Tetris");
        Pane controlPanel = new Pane();
        controlPanel.setPrefSize(500, 100);
        controlPanel.setStyle("-fx-background-color: #f0f0f0;");
        canvas.setBottom(controlPanel);
        Button rotateButton = new Button("Rotate");
        controlPanel.getChildren().add(rotateButton);
        Pane mainPanel = new Pane();
        mainPanel.setPrefSize(500, 400);
        mainPanel.setStyle("-fx-background-color: #ffffff;");
        canvas.setCenter(mainPanel);
        for (int i = 0; i < 500; i += 50) {
            Line line = new Line(i, 0, i, 500);
            line.setStroke(Color.BLACK);
            mainPanel.getChildren().add(line);
        }
        for (int i = 0; i < 500; i += 50) {
            Line line = new Line(0, i, 500, i);
            line.setStroke(Color.BLACK);
            mainPanel.getChildren().add(line);
        }
    }

    public static void main(String[] args) {
        Tetris.launch(args);
    }
}
