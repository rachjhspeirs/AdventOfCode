package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Part1 {

    public static void part1Run() {

        List<String> allLines = fileSplitByLine();

        ArrayList<HashMap<String, String>> allPassports = formatPassports(allLines);
        ArrayList<HashMap<String, String>> validPassports = getValidPassports(allPassports);

        System.out.println("Number of Valid Passports: " + validPassports.size());

    }

    public static List<String> fileSplitByLine() {

        List<String> allLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Day4/passports.txt"));
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;
    }

    public static ArrayList<HashMap<String, String>> formatPassports (List<String> allLines){

        ArrayList<HashMap<String, String>> allPassports = new ArrayList<>();

        for (int i = 0; i < allLines.size(); i++) {

            HashMap<String, String> passport = new HashMap();
            String[] data = allLines.get(i).split(" ");

            for (int j = 0; j < data.length; j++) {
                String[] keyValue = data[j].split(":");
                passport.put(keyValue[0].toString(), keyValue[1].toString());
            }

            allPassports.add(passport);
        }
        return allPassports;

    }

    public static ArrayList<HashMap<String, String>> getValidPassports(ArrayList<HashMap<String, String>> allPassports){
        ArrayList<HashMap<String, String>> validPassports = new ArrayList<>();

        for (int i = 0; i < allPassports.size(); i++) {

            if (allPassports.get(i).containsKey("byr") && allPassports.get(i).containsKey("iyr")
            && allPassports.get(i).containsKey("eyr") && allPassports.get(i).containsKey("hgt")
            & allPassports.get(i).containsKey("hcl") && allPassports.get(i).containsKey("ecl")
            && allPassports.get(i).containsKey("pid")) {
                validPassports.add(allPassports.get(i));
            }
        }

        return validPassports;
    }


}
