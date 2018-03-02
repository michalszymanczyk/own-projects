package pl.checkersgame;

import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int TILE_SIZE = 80;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    Piece previousPieceType = null;
    TimeCounter timeCounter = new TimeCounter();
    private long redPieceTime;
    private long goldPieceTime;

    private Tile[][] board = new Tile[WIDTH][HEIGHT];

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    private List<Piece> goldPiece = new ArrayList();
    private List<Piece> redPiece = new ArrayList();

    public void createTileTable() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Tile tile = new Tile((i + j) % 2 == 0, i, j);
                board[j][i] = tile;
                tileGroup.getChildren().add(tile);

                Piece piece = null;

                if (i <= 2 && (i + j) % 2 != 0) {
                    piece = makePiece(PieceType.GOLD, j, i);
                    goldPiece.add(piece);
                }

                if (i >= 5 && (i + j) % 2 != 0) {
                    piece = makePiece(PieceType.RED, j, i);
                    redPiece.add(piece);
                }

                if (piece != null) {
                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }
    }

    private MoveResult tryMove(Piece piece, int newX, int newY) {
        if (board[newX][newY].hasPiece() || (newX + newY) % 2 == 0) {
            return new MoveResult(MoveType.NONE);
        }

        int x0 = toBoard(piece.getOldX());
        int y0 = toBoard(piece.getOldY());

        if (Math.abs(newX - x0) == 1 && newY - y0 == piece.getPieceType().moveDirection) {
            return new MoveResult(MoveType.NORMAL);
        } else if (Math.abs(newX - x0) == 2 && newY - y0 == piece.getPieceType().moveDirection * 2) {
            int x1 = x0 + (newX - x0) / 2;
            int y1 = y0 + (newY - y0) / 2;
            if (board[x1][y1].hasPiece() && board[x1][y1].getPiece().getPieceType() != piece.getPieceType()) {
                return new MoveResult(MoveType.KILL, board[x1][y1].getPiece());
            }
        }

        return new MoveResult(MoveType.NONE);
    }

    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);
        piece.setOnMouseReleased(e -> {
            timeCounter.setTimeStart();
            int newX = toBoard(piece.getLayoutX());
            int newY = toBoard(piece.getLayoutY());

            if (previousPieceType == null) {
                movePiece(piece, newX, newY);
                previousPieceType = piece;
            }

            if (!piece.getPieceType().equals(previousPieceType.getPieceType())) {
                movePiece(piece, newX, newY);
                previousPieceType = piece;
            } else {
                piece.abortMove();
            }
            timeCounter.setTimeStop(piece);
        });
        return piece;
    }

    private void movePiece(Piece piece, int newX, int newY) {
        MoveResult result = tryMove(piece, newX, newY);

        int x0 = toBoard(piece.getOldX());
        int y0 = toBoard(piece.getOldY());
        switch (result.getType()) {
            case NONE:
                piece.abortMove();
                sumAllTime();
                break;
            case NORMAL:
                piece.move(newX, newY);
                board[x0][y0].setPiece(null);
                board[newX][newY].setPiece(piece);
                sumAllTime();
                break;
            case KILL:
                piece.move(newX, newY);
                board[x0][y0].setPiece(null);
                board[newX][newY].setPiece(piece);
                Piece otherPiece = result.getPiece();
                removeOponentPiece(piece);
                checkIfPieceExist();
                board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null);
                pieceGroup.getChildren().remove(otherPiece);
                sumAllTime();
                break;
        }
    }

    private void removeOponentPiece(Piece piece) {
        if (piece.getPieceType().equals(PieceType.GOLD)) {
            redPiece.remove(0);
        } else if (piece.getPieceType().equals(PieceType.RED)) {
            goldPiece.remove(0);

        }

    }

    private int toBoard(double pixel) {
        return (int) (pixel + TILE_SIZE / 2) / TILE_SIZE;
    }

    public Group getTileGroup() {
        return tileGroup;
    }

    public Group getPieceGroup() {
        return pieceGroup;
    }

    private void sumAllTime() {
        goldPieceTime = timeCounter.sumAllTime(timeCounter.getGoldPieceTime());
        redPieceTime = timeCounter.sumAllTime(timeCounter.getRedPieceTime());
    }

    public void checkIfPieceExist() {
        if (goldPiece.isEmpty()) {
            System.out.println("RED WIN");
        } else if (redPiece.isEmpty()) {
            System.out.println("GOLD WIN");
        }
    }


}
