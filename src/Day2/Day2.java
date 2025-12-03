package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public long part1() throws FileNotFoundException {

        long total = 0;
        List<Long> idList = new ArrayList<>();
        Scanner scanner;
        scanner = new Scanner(new File("src/Day2/input.txt"));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] ranges = input.split(",");
            for (String textRange : ranges) {
                Range range = new Range(textRange);
                idList.addAll(range.getInvalidIds(range));
            }
            for (Long id : idList) {
                total += id;
            }
        }
        scanner.close();
        return total;

    }

    public long part2() throws FileNotFoundException {
        long total = 0;
        List<Long> idList = new ArrayList<>();
        Scanner scanner;
        scanner = new Scanner(new File("src/Day2/input.txt"));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] ranges = input.split(",");
            for (String textRange : ranges) {
                Range range = new Range(textRange);
                idList.addAll(range.getInvalidIdsPartTwo(range));
            }
            for (Long id : idList) {
                total += id;
            }

        }
        scanner.close();
        return total;
    }
}
