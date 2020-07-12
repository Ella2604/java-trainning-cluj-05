package board;

import piece.Piece;

public class Tile {
    private int position;
    private Piece piece;
    private String label;

    public Tile(int position, Piece piece, String label) {
        this.position = position;
        this.piece = piece;
        this.label = label;
    }

    public Tile(int position) {
        this.position = position;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
