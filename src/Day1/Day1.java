package Day1;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {

    public int part1() throws FileNotFoundException {

        Scanner scanner;
        int currentPos = 50;
        int zeroCounter = 0;

        scanner = new Scanner(new File("src/Day1/input.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            boolean moveLeft = line.charAt(0) == 'L';
            int movement = Integer.parseInt(line.substring(1));

            if (moveLeft) {
                currentPos -= movement;
            } else {
                currentPos += movement;
            }
            currentPos %= 100;

            if (currentPos == 0) {
                zeroCounter++;
            }


        }
        scanner.close();
        return zeroCounter;

    }

    public int part2() throws FileNotFoundException {
        Scanner scanner;
        scanner = new Scanner(new File("src/Day1/input.txt"));
        int zeroCounter = 0;
        int currentPos = 50;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            boolean moveLeft = line.charAt(0) == 'L';
            int movement = Integer.parseInt(line.substring(1));

            int newPosition;
            if (moveLeft) {
                newPosition = ((currentPos - movement) % 100 + 100) % 100;
                // Check if position has wrapped (new position greater than current when moving left)
                if (newPosition > currentPos && currentPos != 0) {
                    zeroCounter++;
                }
            } else {
                newPosition = (currentPos + movement) % 100;
                // Check if position has wrapped (new position less than current when moving right)
                if (newPosition < currentPos && newPosition != 0) {
                    zeroCounter++;
                }
            }
            
            currentPos = newPosition;
            
            // Check for landing directly on zero
            if (currentPos == 0) {
                zeroCounter++;
            }
            
            //Check for complete rotations
            int numberOfRotations = movement / 100;
            zeroCounter += numberOfRotations;
        }
        scanner.close();
        return zeroCounter;
    }
}
