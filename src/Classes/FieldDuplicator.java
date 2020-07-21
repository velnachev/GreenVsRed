package Classes;

import Interfaces.Duplicator;

public class FieldDuplicator implements Duplicator {

    //Duplicate a Playing Field to another one and return said field
    @Override
    public String[][] duplicate(String[][] playingField, int row, int col) {
        String[][] duplicatedField = new String[row][col];

        for (int i = 0; i < duplicatedField.length; i++) {
            for (int j = 0; j < duplicatedField[i].length; j++) {
                duplicatedField[i][j] = playingField[i][j];
            }
        }

        return duplicatedField;
    }
}
