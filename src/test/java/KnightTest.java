import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class KnightTest {

    @ParameterizedTest
    @CsvSource({
        "WHITE, 3, 3, 5, 4, true",
        "WHITE, 3, 3, 4, 5, true",
        "BLACK, 3, 3, 2, 5, true",
        "WHITE, 3, 3, 1, 4, true",
        "BLACK, 3, 3, 1, 2, true",
        "WHITE, 3, 3, 2, 1, true",
        "WHITE, 3, 3, 2, 1, true",
        "BLACK, 3, 3, 4, 1, true",
        "WHITE, 3, 3, 5, 2, true",
        "BLACK, 3, 3, 3, 7, false",
        "WHITE, 3, 3, 3, 3, false",
        "WHITE, 3, 3, 0, 3, false",
        "WHITE, 3, 3, 4, 4, false",
        "BLACK, 3, 3, 2, 2, false",
        "WHITE, 3, 3, 5, 7, false",
    })
    void testKnightMovement(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        boolean expected
    ){
        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Knight knight = new Knight(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = knight.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 3, 4, WHITE, 3, 4, false",
        "BLACK, 2, 2, 3, 4, BLACK, 3, 4, false",
        "WHITE, 2, 2, 3, 4, BLACK, 3, 4, true",
        "BLACK, 2, 2, 3, 4, WHITE, 3, 4, true",
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
        Knight knight = new Knight(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Knight(anotherPieceColor); // Using knight for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = knight.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }
}
