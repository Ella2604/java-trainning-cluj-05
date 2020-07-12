package board;

import piece.Piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Integer, Tile> tiles;

    public Board(Map<Integer, Tile> tiles) {
        this.tiles = tiles;
    }

    public Board() {
        initBoardWithEmptyTiles();
    }

    public void initBoardWithEmptyTiles() {
        tiles = new HashMap<Integer, Tile>();
        for(int i = 1; i <= 64; i++) {
            tiles.put(i, new Tile(i));
        }
    }

    public void movePiece(Piece piece, int newCoordinates) {
        if(piece.getCoordinates() == newCoordinates) {
            return;
        }

        List<Move> possibleMoves = piece.getPossibleMoves(this);
        for(Move move : possibleMoves) {
            if(move.getDestinationCoordinates() == newCoordinates) {
                Tile destinationTile = tiles.get(newCoordinates);
                Tile currentTile = tiles.get(piece.getCoordinates());
                currentTile.setPiece(null);
                destinationTile.setPiece(piece);
                piece.setCoordinates(newCoordinates);
                break;
            }
        }
    }

    public void setPieceOnTile(Piece piece) {
        this.tiles.put(piece.getCoordinates(), new Tile(piece.getCoordinates(), piece, "n/a"));
    }

    public Tile getTileFromCoordinates(int coordinates) {
        return tiles.get(coordinates);
    }

    public Map<Integer, Tile> getTiles() {
        return tiles;
    }

    public void setTiles(Map<Integer, Tile> tiles) {
        this.tiles = tiles;
    }

}
