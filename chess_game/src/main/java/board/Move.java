package board;

import piece.Piece;

public class Move {
    private Piece movedPiece;
    private int destinationCoordinates;
    private Board board;

    private Move(Piece movedPiece, int destinationCoordinates, Board board) {
        this.movedPiece = movedPiece;
        this.destinationCoordinates = destinationCoordinates;
        this.board = board;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public int getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public void setDestinationCoordinates(int destinationCoordinates) {
        this.destinationCoordinates = destinationCoordinates;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static final class NormalMove extends Move {
        public NormalMove(Piece movedPiece, int destinationCoordinates, Board board) {
            super(movedPiece, destinationCoordinates, board);
        }
    }

    public static final class AttackMove extends Move {

        private final Piece attackedPiece;

        public AttackMove(Piece movedPiece, Piece attackedPiece, int destinationCoordinates, Board board) {
            super(movedPiece, destinationCoordinates, board);
            this.attackedPiece = attackedPiece;
        }
    }
}
