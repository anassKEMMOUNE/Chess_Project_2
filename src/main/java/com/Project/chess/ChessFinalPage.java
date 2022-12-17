package com.Project.chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class ChessFinalPage extends Application{
    public void start(Stage stage) throws Exception{
        Pane froot = new Pane();
        stage.setScene(new Scene(froot,600,600));
        Text trt = new Text("CONGRATULATION");
        Button bto = new Button();
        Button btoo = new Button();
        bto.setPrefSize(64,64);
        btoo.setPrefSize(64,64);
        ImageView vi = new ImageView(Piece.initialPath.concat("home.png"));
        ImageView vii = new ImageView(Piece.initialPath.concat("tourner.png"));

        bto.setGraphic(vi);
        bto.setLayoutX(190);
        bto.setLayoutY(470);
        bto.setStyle("-fx-background-color: white; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        btoo.setLayoutX(320);
        btoo.setLayoutY(470);
        btoo.setGraphic(vii);
        btoo.setStyle("-fx-background-color: white; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        trt.setLayoutY(80);
        trt.setLayoutX(55);
        trt.setStyle("-fx-font-size:60");
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 65);
        trt.setFont(font);
        trt.setFill(Color.YELLOW);
        trt.setStrokeWidth(2);
        trt.setStroke(Color.ORANGE);
        froot.getChildren().addAll(new ImageView(Piece.initialPath.concat("finale_background.png")),trt,bto,btoo);
        stage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
