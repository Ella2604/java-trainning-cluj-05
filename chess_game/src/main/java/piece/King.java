package piece;

import board.Board;
import board.BoardUtils;
import board.Move;
import board.Tile;
import enums.PieceColor;
import enums.PieceType;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private static final int[] POSSIBLE_MOVE_COORDINATES = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(int coordinates, PieceType type, PieceColor color) {
        super(coordinates, type, color);
    }

    public List<Move> getPossibleMoves(Board board) {
        List<Move> moves = new ArrayList<Move>();
        int currentCoordinates = super.getCoordinates();
        for(final int possibleCoordinates : POSSIBLE_MOVE_COORDINATES) {
            int destinationCoordinates = currentCoordinates + possibleCoordinates;
            if(!BoardUtils.isValidCoordinates(destinationCoordinates)) {
                continue;
            }
            Tile destinationTile = board.getTileFromCoordinates(destinationCoordinates);
            if(!destinationTile.isOccupied()) {
                boolean validPositionForKing = true;
                for(final int destinationCoordinatesVicinity : POSSIBLE_MOVE_COORDINATES) {
                    Tile vicinityTile = board.getTileFromCoordinates(destinationCoordinates + destinationCoordinatesVicinity);
                    if(vicinityTile.getPiece().getType() == PieceType.KING) {
                        validPositionForKing = false;
                        break;
                    }
                }
                if(validPositionForKing) {
                    moves.add(new Move.NormalMove(this, destinationCoordinates, board));
                }
            } else if(destinationTile.getPiece().getColor() != this.getColor()){
                moves.add(new Move.AttackMove(this, destinationTile.getPiece(), destinationCoordinates, board));
            }
        }
        return moves;    }
}
