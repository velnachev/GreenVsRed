import Classes.FieldDuplicator;
import Classes.PlayingField;
import Interfaces.Duplicator;
import Interfaces.InputParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Read playing field dimensions
        int[] gridSizeDimensions = InputParser.parse(scanner);

        //Assign rows and columns to variables for readability and easy access
        int row = gridSizeDimensions[1];
        int col = gridSizeDimensions[0];

        //Initialize and generate Generation Zero of the Playing Field
        String[][] playingField = new String[row][col];
        for (int i = 0; i < row; i++) {
            playingField[i] = scanner.nextLine().split("");
        }

        //Read coordinates of target cell and Generation N and assign them to variables
        int[] coordinatesAndNumberN = InputParser.parse(scanner);

        int rowTargetCoordinate = coordinatesAndNumberN[1];
        int colTargetCoordinate = coordinatesAndNumberN[0];
        int numberN = coordinatesAndNumberN[2];

        //Assign number of generations to variable and check if target cell of Generation Zero is green
        int generationsCount = 0;
        if (playingField[rowTargetCoordinate][colTargetCoordinate].equals("1")) {
            generationsCount++;
        }

        //Duplicate Generation Zero field as to be able to morph it without affecting main field reference
        Duplicator duplicator = new FieldDuplicator();
        String[][] duplicateGenerationPlayingField = duplicator.duplicate(playingField, row, col);


        //Do next generation of the Field
        for (int generations = 0; generations < numberN; generations++) {
            for (int duplicateRow = 0; duplicateRow <= Math.min(duplicateRow + 1, playingField.length - 1); duplicateRow++) {
                for (int duplicateCol = 0; duplicateCol <= Math.min(duplicateCol + 1, playingField[duplicateRow].length - 1); duplicateCol++) {

                    PlayingField field = new PlayingField(playingField, duplicateGenerationPlayingField, duplicateRow, duplicateCol);

                    field.generate(playingField, duplicateGenerationPlayingField, duplicateRow, duplicateCol);
                }
            }

            //Copy morphed field into Generation Zero Field to follow next generation
            playingField = duplicator.duplicate(duplicateGenerationPlayingField, row, col);

            //Check if target cell is green in current generation
            if (playingField[rowTargetCoordinate][colTargetCoordinate].equals("1")) {
                generationsCount++;
            }
        }

        //Print result
        System.out.println(generationsCount);
    }
}
