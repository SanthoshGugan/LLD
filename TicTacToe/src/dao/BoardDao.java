package dao;

import model.Cell;

public interface BoardDao {

    void putCell(int row, int col, Cell cell);

    Cell getCell(int row, int col);

}
