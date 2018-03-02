package pl.checkersgame;

public enum PieceType {
    GOLD(1),
    RED(-1);

    final int moveDirection;

    PieceType(int moveDirection) {
        this.moveDirection = moveDirection;
    }
}
