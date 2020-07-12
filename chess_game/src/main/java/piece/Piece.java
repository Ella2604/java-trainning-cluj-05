package piece;


import board.Board;
import board.BoardUtils;
import board.Move;
import board.Tile;
import enums.PieceColor;
import enums.PieceType;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private int coordinates;
    private PieceType type;
    private PieceColor color;
    private boolean firstMoved;

    protected Piece(int coordinates, PieceType type, PieceColor color) {
        this.coordinates = coordinates;
        this.type = type;
        this.color = color;
        this.firstMoved = false;
    }

    /**
     * Get possible moves for a piece when selected
     * @param board - board to determine possible moves
     * @return list of possible moves
     */
    public abstract List<Move> getPossibleMoves(Board board);

    /**
     * For pieces like bishop, rook, queen etc where we can get recursive coordinates
     * @param possibleCoordinates
     * @param board
     * @return
     */
    protected List<Move> getRecursiveMovesByCoordinatesRules(int[] possibleCoordinates, Board board) {
        List<Move> moves = new ArrayList<Move>();

        int currentCoordinates = this.coordinates;

        for (final int coordinates : possibleCoordinates) {
            int destinationCoordinates = currentCoordinates + coordinates;
            while(BoardUtils.isValidCoordinates(destinationCoordinates)) {
                Tile destinationTile = board.getTileFromCoordinates(destinationCoordinates);
                if (!destinationTile.isOccupied()) {
                    moves.add(new Move.NormalMove(this, destinationCoordinates, board));
                } else if (destinationTile.getPiece().getColor() != this.getColor()) {
                    moves.add(new Move.AttackMove(this, destinationTile.getPiece(), destinationCoordinates, board));
                    break;
                } else {
                    break;
                }
                destinationCoordinates += coordinates;

            }
        }
        return moves;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public int getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isFirstMoved() {
        return firstMoved;
    }

    public void setFirstMoved(boolean firstMoved) {
        this.firstMoved = firstMoved;
    }
}
