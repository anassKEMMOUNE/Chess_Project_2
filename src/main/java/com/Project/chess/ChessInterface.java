package com.Project.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
        root.getChildren().addAll(new ImageView(Piece.initialPath.concat("landing_background.png")),title,under,cs,heart,txt,btn);
        btn.setLayoutX(191);
        btn.setLayoutY(411);
        btn.setPrefSize(218,63);
        btn.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: #010101; -fx-text-fill: white; -fx-font-weight:700; -fx-font-family:roboto ;-fx-font-size:24;-fx-background-radius:25;-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)"));


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
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: #5e5956");
        Scene scene2 = new Scene(grid, 600, 600);

        btn.setOnMouseClicked(mouseEvent -> stage.setScene(scene2));
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