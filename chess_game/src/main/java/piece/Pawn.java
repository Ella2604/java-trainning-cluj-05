package piece;

import board.Board;
import board.BoardUtils;
import board.Move;
import board.Tile;
import enums.PieceColor;
import enums.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    /**
     * 8 is for normal move, 16 for two rows (if is first moved)
     * 7, 9 are for possible attack moves
     */
    private static final int[] POSSIBLE_MOVE_COORDINATES = {8, 7, 9, 16};

    public Pawn(int coordinates, PieceType type, PieceColor color) {
        super(coordinates, type, color);
    }

    @Override
    public List<Move> getPossibleMoves(Board board) {
        List<Move> moves = new ArrayList<Move>();

        int currentCoordinates = super.getCoordinates();

        for(final int possibleCoordinates : POSSIBLE_MOVE_COORDINATES) {
            int destinationCoordinates = currentCoordinates + (possibleCoordinates * super.getColor().getDirection());
            Tile destinationTile = board.getTileFromCoordinates(destinationCoordinates);
            if(!BoardUtils.isValidCoordinates(destinationCoordinates)) {
                continue;
            }
            if(possibleCoordinates == 8
                    && !destinationTile.isOccupied()) {
                moves.add(new Move.NormalMove( this, destinationCoordinates, board));
            } else if(possibleCoordinates == 16
                    && !super.isFirstMoved()
                    && !destinationTile.isOccupied()) {
                int oneMovement = currentCoordinates + (8 * super.getColor().getDirection());
                if(board.getTileFromCoordinates(oneMovement).getPiece() == null) {
                    moves.add(new Move.NormalMove(this, destinationCoordinates, board));
                }
            } else if((possibleCoordinates == 7 || possibleCoordinates == 9) // possible attack move
                    && destinationTile.isOccupied()
                    && destinationTile.getPiece().getColor() != this.getColor()) {
                moves.add(new Move.AttackMove(this, destinationTile.getPiece(), destinationCoordinates, board));
            }
        }

        return moves;
    }
}
