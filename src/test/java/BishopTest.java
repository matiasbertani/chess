import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BishopTest {

    @ParameterizedTest
    @CsvSource({
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
        "WHITE, 3, 3, 3, 4, false",
        "BLACK, 3, 3, 3, 5, false",
        "WHITE, 3, 3, 3, 6, false",
        "BLACK, 3, 3, 3, 7, false",
        "WHITE, 3, 3, 3, 2, false",
        "BLACK, 3, 3, 3, 1, false",
        "WHITE, 3, 3, 3, 0, false",
        "WHITE, 3, 3, 4, 3, false",
        "BLACK, 3, 3, 5, 3, false",
        "WHITE, 3, 3, 6, 3, false",
        "WHITE, 3, 3, 7, 3, false",
        "BLACK, 3, 3, 2, 3, false",
        "WHITE, 3, 3, 1, 3, false",
        "WHITE, 3, 3, 0, 3, false",
        "WHITE, 3, 3, 3, 3, false",
    })
    void testBishopMovement(
        String colorName,
        int currentRow,
        int currentCol,
        int targetRow,
        int targetCol,
        boolean expected
    ){
        Board board = new Board();

        Color color = Color.valueOf(colorName);
        Bishop bishop = new Bishop(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        boolean result = bishop.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 3, 3, WHITE, 5, 5, true",
        "WHITE, 2, 2, 4, 4, BLACK, 5, 5, true",
        "WHITE, 2, 2, 6, 6, BLACK, 5, 5, false",
        "WHITE, 2, 2, 7, 7, BLACK, 5, 5, false",
        "WHITE, 2, 2, 6, 6, WHITE, 5, 5, false",
        "WHITE, 2, 2, 7, 7, WHITE, 5, 5, false",
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
        Bishop bishop = new Bishop(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Bishop(anotherPieceColor); // Using Bishop for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = bishop.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "WHITE, 2, 2, 5, 5, WHITE, 5, 5, false",
        "BLACK, 2, 2, 5, 5, BLACK, 5, 5, false",
        "WHITE, 2, 2, 5, 5, BLACK, 5, 5, true",
        "BLACK, 2, 2, 5, 5, WHITE, 5, 5, true",
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
        Bishop bishop = new Bishop(color);

        Position currentPosition = board.getPosition(currentRow, currentCol);
        Position targetPosition = board.getPosition(targetRow, targetCol);

        Color anotherPieceColor = Color.valueOf(anotherPieceColorName);
        Piece anotherPiece = new Bishop(anotherPieceColor); // Using Bishop for simplicity, can be any piece.
        Position anotherPiecePosition = board.getPosition(anotherPieceRow, anotherPieceCol);
        anotherPiecePosition.setPiece(anotherPiece);

        boolean result = bishop.isValidMove(board, currentPosition, targetPosition);

        assertEquals(expected, result);
    }
}
