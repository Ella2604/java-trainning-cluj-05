package piece;

import board.Board;
import board.Move;
import enums.PieceColor;
import enums.PieceType;

import java.util.List;

public class Rook extends Piece {

    private static final int[] POSSIBLE_MOVE_COORDINATES = {-8, -1, 1, 8};


    public Rook(int coordinates, PieceType type, PieceColor color) {
        super(coordinates, type, color);
    }

    public List<Move> getPossibleMoves(Board board) {
        return super.getRecursiveMovesByCoordinatesRules(POSSIBLE_MOVE_COORDINATES, board);
    }
}
