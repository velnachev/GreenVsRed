package Interfaces;

import java.util.Arrays;
import java.util.Scanner;

public interface InputParser {
    //Parse Input data
    static int[] parse(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
