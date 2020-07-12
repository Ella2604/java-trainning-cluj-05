package piece;

import board.Board;
import board.Move;
import enums.PieceColor;
import enums.PieceType;

import java.util.List;

public class Queen extends Piece {
    private static final int[] POSSIBLE_MOVE_COORDINATES = {-9, -8, -7, -1, 1, 7, 8, 9};

    public Queen(int coordinates, PieceType type, PieceColor color) {
        super(coordinates, type, color);
    }

    public List<Move> getPossibleMoves(Board board) {
        return super.getRecursiveMovesByCoordinatesRules(POSSIBLE_MOVE_COORDINATES, board);
    }
}
