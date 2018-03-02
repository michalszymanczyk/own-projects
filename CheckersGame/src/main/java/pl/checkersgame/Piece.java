package pl.checkersgame;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece extends StackPane {
    public PieceType pieceType;

    private double mouseX, mouseY;
    private double oldX, oldY;

    public PieceType getPieceType() {
        return pieceType;
    }

    public Piece(PieceType type, int x, int y){
        this.pieceType = type;

        move(x, y );

        Ellipse background = new Ellipse(Board.TILE_SIZE * 0.3125, Board.TILE_SIZE * 0.26);

        background.setFill(Color.BLACK);
        background.setStroke(Color.BLACK);
        background.setStrokeWidth(Board.TILE_SIZE * 0.03);

        background.setTranslateX((Board.TILE_SIZE - Board.TILE_SIZE * 0.3125 * 2) / 2);
        background.setTranslateY((Board.TILE_SIZE - Board.TILE_SIZE * 0.26 * 2) / 2 + Board.TILE_SIZE * 0.08);

        Ellipse ellipse = new Ellipse(Board.TILE_SIZE * 0.3125, Board.TILE_SIZE * 0.26);
        ellipse.setFill(type == PieceType.GOLD ? Color.GOLD : Color.RED);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(Board.TILE_SIZE * 0.03);

        ellipse.setTranslateX((Board.TILE_SIZE - Board.TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((Board.TILE_SIZE - Board.TILE_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(background, ellipse);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void move(int x, int y){
        oldX = x*Board.TILE_SIZE;
        oldY = y*Board.TILE_SIZE;
        relocate(oldX, oldY);
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void abortMove(){
        relocate(oldX, oldY);
    }
}
