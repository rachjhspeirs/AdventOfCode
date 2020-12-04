package Day4;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Part1 p1 = new Part1();
        ArrayList<HashMap<String, String>> validPassports = p1.part1Run();
        Part2 p2 = new Part2();
        ArrayList<HashMap<String, String>> realValidPassports = p2.getRealValidPassports(validPassports);
        System.out.println("Real Number of Valid Passports: " + realValidPassports.size());
    }
}
