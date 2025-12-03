import Day1.Day1;
import Day2.Day2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        runDay1();
        runDay2();
    }

    public static void runDay1() throws FileNotFoundException {
        Day1 day1 = new Day1();
        System.out.println("Part 1 Result: " + day1.part1());
        System.out.println("Part 2 Result: " + day1.part2());
    }

    public static void runDay2() throws FileNotFoundException {
        Day2 day2 = new Day2();
        System.out.println("Part 1 Result: " + day2.part1());
        System.out.println("Part 2 Result: " + day2.part2());
    }
}