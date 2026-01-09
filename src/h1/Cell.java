package h1;

public class Cell {
	
	private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this(indexRow, indexCol, false);
    }

    public int getIndexRow() { return indexRow; }
    public int getIndexCol() { return indexCol; }
    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public int getNumLivingNeighbors() { return numLivingNeighbors; }
    public boolean isAliveNextGen() { return isAliveNextGen; }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int count = 0;

        for (int r = indexRow - 1; r <= indexRow + 1; r++) {
            for (int c = indexCol - 1; c <= indexCol + 1; c++) {

                if (r == indexRow && c == indexCol) continue;

                if (r >= 0 && r < gridArray.length &&
                    c >= 0 && c < gridArray[0].length &&
                    gridArray[r][c].isAlive()) {
                    count++;
                }
            }
        }

        this.numLivingNeighbors = count;
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (alive) {
            isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
        } else {
            isAliveNextGen = (numLivingNeighbors == 3);
        }
    }
}
