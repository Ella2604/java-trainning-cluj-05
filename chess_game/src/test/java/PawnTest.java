import board.Board;
import board.Tile;
import enums.PieceColor;
import enums.PieceType;
import org.junit.Test;
import piece.Pawn;
import piece.Piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PawnTest {

    @Test
    public void downMovement() {
        Board board = new Board();
        Piece pawn = new Pawn(9, PieceType.PAWN, PieceColor.BLACK);
        board.setPieceOnTile(pawn);

        board.movePiece(pawn, 17);
        assertEquals(pawn.getCoordinates(), 17);
    }

    @Test
    public void upMovement() {
        Board board = new Board();
        Piece pawn = new Pawn(49, PieceType.PAWN, PieceColor.WHITE);
        board.setPieceOnTile(pawn);
        board.movePiece(pawn, 49-16);
        assertEquals(pawn.getCoordinates(), 49-16);
    }

    @Test
    public void conflict() {
        Board board = new Board();
        Piece blackPawn = new Pawn(9, PieceType.PAWN, PieceColor.BLACK);
        board.setPieceOnTile(blackPawn);

        Piece whitePawn = new Pawn(9+8+1, PieceType.PAWN, PieceColor.WHITE);
        board.setPieceOnTile(whitePawn);

        board.movePiece(blackPawn, 9+8+1);
        Tile blackOldCoord = board.getTileFromCoordinates(9);
        assertNull(blackOldCoord.getPiece());

        Tile blackNewCoord = board.getTileFromCoordinates(9 + 8 + 1);
        assertEquals(blackNewCoord.getPiece(), blackPawn);
    }

    @Test
    public void invalidDestinations() {
        Board board = new Board();
        Piece pawn = new Pawn(64, PieceType.PAWN, PieceColor.WHITE);
        board.setPieceOnTile(pawn);
        board.movePiece(pawn, 64+16); //down movement when white
        assertEquals(pawn.getCoordinates(), 64);

        board.movePiece(pawn, 63); //left movement
        assertEquals(pawn.getCoordinates(), 64);

        board.movePiece(pawn, 65); // out of bound
        assertEquals(pawn.getCoordinates(), 64);

        board.movePiece(pawn, 64-8-1); //diagonal movement without black piece
        assertEquals(pawn.getCoordinates(), 64);
    }

    @Test
    public void conflictSameColor() {
        Board board = new Board();
        Piece pawn1 = new Pawn(64, PieceType.PAWN, PieceColor.WHITE);
        board.setPieceOnTile(pawn1);
        Piece pawn2 = new Pawn(64-8, PieceType.PAWN, PieceColor.WHITE);
        board.setPieceOnTile(pawn2);

        board.movePiece(pawn1, 64-8);
        assertEquals(board.getTileFromCoordinates(64-8).getPiece(), pawn2);
        assertEquals(board.getTileFromCoordinates(64).getPiece(), pawn1);

        board.movePiece(pawn1, 64-16);

        assertEquals(board.getTileFromCoordinates(64-8).getPiece(), pawn2);
        assertEquals(board.getTileFromCoordinates(64).getPiece(), pawn1);
    }
}
