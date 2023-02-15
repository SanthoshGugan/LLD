package dao.impl;

import dao.BoardDao;
import model.Cell;

public class BoardDaoImpl implements BoardDao {
    private static BoardDaoImpl boardDaoImpl;
    
    private Cell[][] cells;
    
    private BoardDaoImpl(final int size) {
        cells = new Cell[size][size];
    }
    
    public static BoardDaoImpl getInstance(final int size) {
        if (boardDaoImpl == null) {
            boardDaoImpl = new BoardDaoImpl(size);
        }
        return boardDaoImpl;
    }

    @Override
    public void putCell(final int row, final int col, final Cell cell) {
        if (cells.length <= row || cells[0].length <= col) {
            throw new RuntimeException("Cell position out of bound");
        }
        cells[row][col] = cell;
    }

    @Override
    public Cell getCell(final int row, final int col) {
        if (cells.length <= row || cells[0].length <= col) {
            throw new RuntimeException("Cell position out of bound");
        }
        return cells[row][col];
    }
}
