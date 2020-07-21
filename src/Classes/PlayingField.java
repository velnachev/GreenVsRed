package Classes;

import Interfaces.Field;

public class PlayingField implements Field {
    private String[][] playingField;
    private String[][] duplicateField;
    int row;
    int col;

    public PlayingField(String[][] playingField, String[][] duplicateField, int row, int col) {
        this.playingField = playingField;
        this.duplicateField = duplicateField;
        this.row = row;
        this.col = col;
    }

    //Next generation of the playing Field
    public void generate(String[][] playingField, String[][] duplicateField, int row, int col) {

        if (playingField[row][col].equals("0")) {
            int adjacentGreenCells = 0;
            for (int i = Math.max(0, row - 1); i < Math.min(row + 2, playingField.length); i++) {
                for (int j = Math.max(0, col -1); j < Math.min(col + 2, playingField[row].length); j++) {
                    if (i == row && j == col) {
                        //do nothing
                    } else {
                        if (playingField[i][j].equals("1")) {
                            adjacentGreenCells++;
                        }
                    }
                    if (adjacentGreenCells == 3 || adjacentGreenCells == 6) {
                        duplicateField[row][col] = "1";
                    } else {
                        duplicateField[row][col] = "0";
                    }
                }
            }
        } else if (playingField[row][col].equals("1")) {
            int adjacentGreenCells = 0;
            for (int i = Math.max(0, row - 1); i < Math.min(row + 2, playingField.length); i++) {
                for (int j = Math.max(0, col -1); j < Math.min(col + 2, playingField[row].length); j++) {
                    if (i == row && j == col) {
                        //do nothing
                    } else {
                        if (playingField[i][j].equals("1")) {
                            adjacentGreenCells++;
                        }
                    }
                    if (adjacentGreenCells == 3 || adjacentGreenCells == 6 || adjacentGreenCells == 2) {
                        duplicateField[row][col] = "1";
                    } else {
                        duplicateField[row][col] = "0";
                    }
                }
            }
        }
    }
}
