package com.Project.chess;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ChessInterface extends Application {


    public static int selected;
    public static Piece selectedPiece;
    public static Board board;

    public static ArrayList<Piece> oldSelectedPieces = new ArrayList<>();

    public void start(Stage stage) {

        Pane root = new Pane();
        Scene scene1 =new Scene(root,600,600);

        Button btn = new Button("Let's Play !");
        ImageView title = new ImageView(Piece.initialPath.concat("chesstitle.png"));
        ImageView under = new ImageView(Piece.initialPath.concat("undertitle.png"));
        ImageView cs = new ImageView(Piece.initialPath.concat("cspng.png"));
        ImageView heart = new ImageView(Piece.initialPath.concat("heart.png"));
        Text madeby = new Text("Made With        by UM6P-CS Students");
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
        madeby.setLayoutX(324);
        madeby.setLayoutY(582);
        madeby.setStyle("-fx-fill: white;-fx-font-size:16");
        root.getChildren().addAll(new ImageView(Piece.initialPath.concat("landing_background.png")),title,under,cs,heart,madeby,btn);
        btn.setLayoutX(191);
        btn.setLayoutY(411);
        btn.setPrefSize(218,63);
        btn.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));



        Pane toot = new Pane();
        Scene tootScene = new Scene(toot,600,600);
        Button btn2 = new Button("Classic");
        Button btn1 = new Button("Quick Game");
        btn2.setOnMouseEntered(e -> btn2.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)")
        );
        btn2.setOnMouseExited(e -> btn2.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));
        btn1.setOnMouseEntered(e -> btn1.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));
        btn1.setOnMouseExited(e -> btn1.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));
        Text txt = new Text("Player 2");
        Text txt2 = new Text("Player 1");
        Text txt3 = new Text("READY ?");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        t1.setStyle("-fx-background-radius:25;-fx-border-radius:25; -fx-border-color: black;-fx-border-width: 3px ; -fx-font-size: 18; -fx-font-weight: 600");
        t2.setStyle("-fx-background-radius:25;-fx-border-radius:25; -fx-border-color: black;-fx-border-width: 3px ; -fx-font-size: 18; -fx-font-weight: 600");
        txt.setLayoutX(120);
        txt.setLayoutY(350);
        txt.setStyle("-fx-font-size:29");
        txt2.setLayoutX(120);
        txt2.setLayoutY(267);
        txt2.setStyle("-fx-font-size:29");
        txt3.setLayoutX(185);
        txt3.setLayoutY(100);
        txt3.setStyle("-fx-font-size:80");
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 65);
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 65);
        txt3.setFont(font);
        txt2.setFont(font1);
        txt.setFont(font1);
        txt3.setFill(Color.BLACK);
        txt3.setStrokeWidth(2);
        txt3.setStroke(Color.WHITE);
        txt2.setFill(Color.WHITE);
        txt2.setStrokeWidth(2);
        txt2.setStroke(Color.BLACK);
        txt.setFill(Color.WHITE);
        txt.setStrokeWidth(2);
        txt.setStroke(Color.BLACK);
        DropShadow shadow = new DropShadow();
        txt3.setEffect(shadow);
        txt2.setEffect(shadow);
        txt.setEffect(shadow);
        t1.setLayoutX(280);
        t2.setLayoutY(322);
        t1.setPrefSize(250, 40);
        t2.setPrefSize(250, 40);
        t2.setLayoutX(280);
        t1.setLayoutY(238);
        toot.getChildren().addAll(new ImageView(Piece.initialPath.concat("page2_background.png")),txt,txt2,txt3,btn2,btn1,t1,t2);
        btn2.setLayoutX(70);
        btn2.setLayoutY(530);
        btn2.setPrefSize(218,63);
        btn2.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        btn1.setLayoutX(310);
        btn1.setLayoutY(530);
        btn1.setPrefSize(218,63);
        btn1.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");

        board = new Board();
        GridPane grid = board.grid;



        //board.player1.moveAnass(0);
        for (int i=0;i<8;i++){
            int a = i;
            board.player1.PawnsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.PawnsArray.get(a).clickEvent(a));
            board.player2.PawnsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.PawnsArray.get(a).clickEvent(a));

        }
        for (int i=0;i<2;i++){
            int a = i;
            board.player1.RooksArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.RooksArray.get(a).clickEvent(a));
            board.player2.RooksArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.RooksArray.get(a).clickEvent(a));
            board.player1.KnightsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.KnightsArray.get(a).clickEvent(a));
            board.player2.KnightsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.KnightsArray.get(a).clickEvent(a));
            board.player1.BishopsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player1.BishopsArray.get(a).clickEvent(a));
            board.player2.BishopsArray.get(i).getImage().setOnMouseClicked(mouseEvent -> board.player2.BishopsArray.get(a).clickEvent(a));
            board.player1.king.getImage().setOnMouseClicked(mouseEvent -> board.player1.king.clickEvent(a));
            board.player2.king.getImage().setOnMouseClicked(mouseEvent -> board.player2.king.clickEvent(a));
            board.player1.queen.getImage().setOnMouseClicked(mouseEvent -> board.player1.queen.clickEvent(a));
            board.player2.queen.getImage().setOnMouseClicked(mouseEvent -> board.player2.queen.clickEvent(a));
        }


        for (int i=0;i<8;i++){
            int c =  i;
            for (int j =0;j<8;j++){
                int b = j;

                board.cells[i][j].getTile().setOnMouseClicked(mouseEvent -> board.cells[c][b].clickEvent(c,b));
            }
        }



        //board.getChildren().remove(a);
        grid.setLayoutX(44);
        grid.setLayoutY(44);
        board.container.setStyle("-fx-background-color: #5e5956");





        Scene scene2 = new Scene(board.container, 600, 600);
        Text player1out = new Text();
        Text player2out = new Text();
        player1out.setLayoutX(490);
        player2out.setLayoutY(30);
        player1out.setStyle("-fx-font-family: roboto; -fx-font-size: 20 ; -fx-fill: white; -fx-font-weight: 700; -fx-stroke: black ");
        player2out.setLayoutX(50);
        player1out.setLayoutY(582);
        player2out.setStyle("-fx-font-family: roboto; -fx-font-size: 20 ; -fx-fill: black;-fx-font-weight: 700; -fx-stroke: #868484");
        btn.setOnMouseClicked(mouseEvent -> stage.setScene(tootScene));
        btn2.setOnMouseClicked(mouseEvent -> {stage.setScene(scene2);
                    board.player1.setName(t1.getText());
                    board.player2.setName(t2.getText());
                    player1out.setText(board.player1.getName().toUpperCase());
                    player2out.setText(board.player2.getName().toUpperCase());
                    board.container.getChildren().addAll(player1out,player2out);
                    System.out.println(board.player1.getName());
                }
        );

        stage.setResizable(false);
        stage.setScene(scene1);
        stage.show();


    }


    public static int getSelected() {
        return selected;
    }

    public static void setSelected(int selected) {
        ChessInterface.selected = selected;
    }
    public static Piece getSelectedPiece() {
        return selectedPiece;
    }

    public static void setSelectedPiece(Piece selected) {
        ChessInterface.selectedPiece = selected;
    }

    public static void main(String[] args) {
        launch(args);


    }
}