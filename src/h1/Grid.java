package h1;

public class Grid {
	
	private Cell[][] gridArray;

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c] = new Cell(r, c, false);
            }
        }

        for (Cell cell : cells) {
            int r = cell.getIndexRow();
            int c = cell.getIndexCol();
            if (r >= 0 && r < gridRows && c >= 0 && c < gridCols) {
                gridArray[r][c].setAlive(true);
            }
        }

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {
        int rows = gridArray.length;
        int cols = gridArray[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                gridArray[r][c].setAlive(gridArray[r][c].isAliveNextGen());
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}
