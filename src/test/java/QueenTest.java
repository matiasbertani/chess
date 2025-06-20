import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class QueenTest {

    @ParameterizedTest
    @CsvSource({
        // Moves like a Baship
        "WHITE, 3, 3, 4, 4, true",
        "WHITE, 3, 3, 5, 5, true",
        "WHITE, 3, 3, 6, 6, true",
        "WHITE, 3, 3, 2, 2, true",
        "WHITE, 3, 3, 2, 2, true",
        "WHITE, 3, 3, 2, 4, true",
        "WHITE, 3, 3, 1, 5, true",
        "WHITE, 3, 3, 0, 6, true",
        "WHITE, 3, 3, 4, 2, true",
        "WHITE, 3, 3, 5, 1, true",
        "WHITE, 3, 3, 6, 0, true",
        "WHITE, 2, 5, 3, 6, true",
        "WHITE, 2, 5, 4, 7, true",
        "WHITE, 2, 5, 1, 4, true",
        "WHITE, 2, 5, 0, 3, true",
        "WHITE, 2, 5, 1, 6, true",
        // Moves like a Rook
        "WHITE, 3, 3, 3, 4, true",
        "BLACK, 3, 3, 3, 5, true",
        "WHITE, 3, 3, 3, 6, true",
        "BLACK, 3, 3, 3, 7, true",
        "WHITE, 3, 3, 3, 2, true",
        "BLACK, 3, 3, 3, 1, true",
        "WHITE, 3, 3, 3, 0, true",
        "WHITE, 3, 3, 4, 3, true",
        "BLACK, 3, 3, 5, 3, true",
        "WHITE, 3, 3, 6, 3, true",
        "WHITE, 3, 3, 7, 3, true",
        "BLACK, 3, 3, 2, 3, true",
        "WHITE, 3, 3, 1, 3, true",
        "WHITE, 3, 3, 0, 3, true",
        // Cant move like Knight
        "WHITE, 3, 3, 5, 4, false",
        "WHITE, 3, 3, 4, 5, false",
        "BLACK, 3, 3, 2, 5, false",
        "WHITE, 3, 3, 1, 4, false",
        "BLACK, 3, 3, 1, 2, false",
        "WHITE, 3, 3, 2, 1, false",
        "WHITE, 3, 3, 2, 1, false",
        "BLACK, 3, 3, 4, 1, false",
        "WHITE, 3, 3, 5, 2, false",
        // Invalid moves
        "WHITE, 3, 3, 4, 5, false",
        "BLACK, 3, 3, 4, 6, false",
        "WHITE, 3, 3, 5, 6, false",
        "BLACK, 3, 3, 5, 4, false",
        "WHITE, 3, 3, 6, 4, false",
        "BLACK, 3, 3, 6, 5, false",
        "WHITE, 3, 3, 5, 2, false",
        "WHITE, 3, 3, 6, 2, false",
        "BLACK, 3, 3, 6, 1, false",
        "WHITE, 3, 3, 5, 0, false",
        "WHITE, 3, 3, 4, 0, false",
        "BLACK, 3, 3, 4, 1, false",
        "WHITE, 3, 3, 2, 1, false",
        "WHITE, 3, 3, 2, 0, false",
        "WHITE, 3, 3, 1, 0, false",
        "WHITE, 3, 3, 1, 2, false",
        "WHITE, 3, 3, 0, 2, false",
        "BLACK, 3, 3, 0, 1, false",
        "WHITE, 3, 3, 1, 4, false",
        "WHITE, 3, 3, 0, 4, false",
        "WHITE, 3, 3, 0, 5, false",
        "WHITE, 3, 3, 2, 5, false",
        "WHITE, 3, 3, 2, 6, false",
        "WHITE, 3, 3, 1, 6, false",
        "WHITE, 3, 3, 3, 3, false",
    })
    void testQueenMovement(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        boolean expected
    ){
        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Queen queen = new Queen(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = queen.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
        // moves like a Bishop
        "WHITE, 2, 2, 3, 3, WHITE, 5, 5, true",
        "WHITE, 2, 2, 4, 4, BLACK, 5, 5, true",
        "WHITE, 2, 2, 6, 6, BLACK, 5, 5, false",
        "WHITE, 2, 2, 7, 7, BLACK, 5, 5, false",
        "WHITE, 2, 2, 6, 6, WHITE, 5, 5, false",
        "WHITE, 2, 2, 7, 7, WHITE, 5, 5, false",
        // Moves like a Rook
        "WHITE, 2, 2, 2, 3, WHITE, 2, 5, true",
        "WHITE, 2, 2, 2, 4, BLACK, 2, 5, true",
        "WHITE, 2, 2, 2, 6, BLACK, 2, 5, false",
        "WHITE, 2, 2, 2, 7, BLACK, 2, 5, false",
        "WHITE, 2, 2, 2, 6, WHITE, 2, 5, false",
        "WHITE, 2, 2, 2, 7, WHITE, 2, 5, false",
    })
    void itCanNotMoveWhenThereIsAnotherPieceInTheWay(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        String anotherPieceColorName,
        int anotherPieceRow,
        int anotherPieceCol,
        boolean expected
    ) {

        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Queen queen = new Queen(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Queen(anotherPieceColor); // Using Queen for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = queen.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 5, 5, WHITE, 5, 5, false",
        "BLACK, 2, 2, 5, 5, BLACK, 5, 5, false",
        "WHITE, 2, 2, 5, 5, BLACK, 5, 5, true",
        "BLACK, 2, 2, 5, 5, WHITE, 5, 5, true",
        "WHITE, 2, 2, 2, 5, WHITE, 2, 5, false",
        "BLACK, 2, 2, 2, 5, BLACK, 2, 5, false",
        "WHITE, 2, 2, 2, 5, BLACK, 2, 5, true",
        "BLACK, 2, 2, 2, 5, WHITE, 2, 5, true",
    })
    void itCanNotMoveToTargetPositionWithFriendlyPiece(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        String anotherPieceColorName,
        int anotherPieceRow,
        int anotherPieceCol,
        boolean expected
    ) {

        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Queen queen = new Queen(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Queen(anotherPieceColor); // Using Queen for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = queen.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }
}
