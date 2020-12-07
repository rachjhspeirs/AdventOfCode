package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> allLines = fileSplitByLine();
        ArrayList<String> distinctChars = getDistinctChars(allLines);
        int totalVal = getTotalSum(distinctChars);

        System.out.println("Part 1 - Total Sum: " + totalVal);
    }

    public static ArrayList<String> fileSplitByLine() {

        ArrayList<String> allLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Day6/customs.txt"));
            String str = "";

            while (true) {
                String temp = br.readLine();
                if (temp == null) {
                    allLines.add(str);
                    break;
                }
                if (temp.isEmpty()) {
                    if (!str.isEmpty()) {
                        allLines.add(str);
                    }
                    str = "";
                } else {
                    if (str.isEmpty()) {
                        str = temp;
                    } else {
                        str += " " + temp;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }

    public static ArrayList<String> getDistinctChars(ArrayList<String> allLines){

        ArrayList<String> distinctChars = new ArrayList<>();

        for (int i = 0; i < allLines.size(); i++) {

            char[] chars = allLines.get(i).replace(" ","").toCharArray();
            Set<Character> characterSet = new LinkedHashSet<Character>();

            for (char c: chars) {
                characterSet.add(c);
            }

            StringBuilder sb = new StringBuilder();
            for (Character character: characterSet) {
                sb.append(character);
            }
            distinctChars.add(sb.toString());
        }
        return distinctChars;
    }

    public static int getTotalSum(ArrayList<String> distinctVals){

        ArrayList<Integer> values = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < distinctVals.size(); i++) {
            int value = distinctVals.get(i).length();
            values.add(value);
        }

        for (int i = 0; i < values.size(); i++) {
            total+=values.get(i);
        }
        return total;
    }
}
