package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {
    @Test
    public void whenCreateBishopBlackThenPositionIsCorrect() {
        Cell startPosition = Cell.A1;
        Figure bishopBlack = new BishopBlack(startPosition);
        assertThat(bishopBlack.position()).isEqualTo(startPosition);
    }

    @Test
    public void whenCopyBishopBlackThenPositionIsUpdated() {
        Cell startPosition = Cell.A1;
        Figure bishopBlack = new BishopBlack(startPosition);
        Cell newPosition = Cell.H8;
        Figure copiedBishopBlack = bishopBlack.copy(newPosition);
        assertThat(copiedBishopBlack.position()).isEqualTo(newPosition);
    }

    @Test
    public void whenBishopBlackMovesThanPathIsCorrect() {
        Cell startPosition = Cell.C1;
        Figure bishopBlack = new BishopBlack(startPosition);
        Cell[] expectedPath = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] actualPath = bishopBlack.way(Cell.G5);
        assertThat(actualPath).isEqualTo(expectedPath);
    }

    @Test
    public void whenBishopBlackMovesDiagonally() {
        Cell startPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell newPosition = Cell.G5;
        boolean result = bishopBlack.isDiagonal(startPosition, newPosition);
        assertTrue(result, "BishopBlack should move diagonally from C1 to G5");
    }

    @Test
    public void whenBishopBlackNotMoveDiagonally() {
        Cell startPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell newPosition = Cell.C2;
        boolean result = bishopBlack.isDiagonal(startPosition, newPosition);
        assertFalse(result, "BishopBlack should not move diagonally from C1 to C5");
    }

    @Test
    public void whenBishopBlackSameSourceAndDestination() {
        Cell startPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell newPosition = Cell.C1;
        boolean result = bishopBlack.isDiagonal(startPosition, newPosition);
        assertFalse(result,
                "BishopBlack should not consider the same source and destination as diagonal move");
    }

    @Test
    public void whenNotDiagonalMoveThanThrowImpossibleMoveException() {
        Cell startPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        Cell newPosition = Cell.A1;
        assertThrows(ImpossibleMoveException.class, () -> bishopBlack.way(newPosition));
    }
}