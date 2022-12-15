package com.Project.chess;
import java.util.Stack;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;

public class landingPage extends Application{
    public void start(Stage stage) throws Exception{
        Pane root = new Pane();
        stage.setScene(new Scene(root,600,600));
        Button btn = new Button("Let's Play !");
        ImageView title = new ImageView("/images/chesstitle.png");
        ImageView under = new ImageView("/imageundertitle.png");
        ImageView cs = new ImageView("cspng.png");
        ImageView heart = new ImageView("heart.png");
        Text txt = new Text("Made With        by UM6P-CS Students");
        title.setLayoutX(184);
        title.setLayoutY(36);
        title.setFitWidth(232);
        title.setFitHeight(63);
        under.setLayoutX(231);
        under.setLayoutY(108);
        under.setFitWidth(141);
        under.setFitHeight(37);
        cs.setLayoutX(0);
        cs.setLayoutY(505);
        cs.setFitWidth(200);
        cs.setFitHeight(87);
        heart.setLayoutX(409);
        heart.setLayoutY(567);
        heart.setFitWidth(24);
        heart.setFitHeight(20);
        txt.setLayoutX(324);
        txt.setLayoutY(582);
        txt.setStyle("-fx-fill: white;-fx-font-size:16");
        root.getChildren().addAll(new ImageView("landing_background.png"),title,under,cs,heart,txt,btn);
        btn.setLayoutX(191);
        btn.setLayoutY(411);
        btn.setPrefSize(218,63);
        btn.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");

        stage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}