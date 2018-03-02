package pl.checkersgame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheckersRunner extends Application {
    private Board board = new Board();

    private Parent createStage() {
        Pane root = new Pane();
        root.setPrefSize(Board.WIDTH * Board.TILE_SIZE, Board.HEIGHT * Board.TILE_SIZE);
        board.createTileTable();
        root.getChildren().addAll(board.getTileGroup(), board.getPieceGroup());
        return root;
    }

    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createStage());
        primaryStage.setTitle("Warcaby");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
