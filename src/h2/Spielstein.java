package h2;

public class Spielstein {
	
	private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];
        char dir = aktuellesFeld.getDirection();
        int dim = brett.getDim();

        return (dir == 'U' && currentRow == 0)
            || (dir == 'D' && currentRow == dim - 1)
            || (dir == 'L' && currentCol == 0)
            || (dir == 'R' && currentCol == dim - 1);
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {

            Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];

            if (aktuellesFeld.isBoese()) {
                continue;
            }

            if (movesOut()) {
                continue;
            }

            switch (aktuellesFeld.getDirection()) {
                case 'U':
                    currentRow--;
                    break;
                case 'D':
                    currentRow++;
                    break;
                case 'L':
                    currentCol--;
                    break;
                case 'R':
                    currentCol++;
                    break;
                default:
                    break;
            }
        }
    }
}
