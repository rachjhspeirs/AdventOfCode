package Day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Part2 {

    public static ArrayList<HashMap<String, String>> getRealValidPassports(ArrayList<HashMap<String, String>> validPassports){
        ArrayList<HashMap<String, String>> realValidPassports= new ArrayList<>();

        outerloop:
        for (HashMap<String, String> validPassport : validPassports) {

            boolean valid = false;
            Iterator it = validPassport.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                switch (pair.getKey().toString()) {
                    case "byr":
                        if (String.valueOf(pair.getValue()).length() == 4) {
                            if (((Integer.parseInt((String) pair.getValue())) >= 1920) && ((Integer.parseInt((String) pair.getValue())) <= 2002)) {
                                valid = true;
                            } else {
                                continue outerloop;
                            }
                        } else {
                            continue outerloop;
                        }
                        break;
                    case "iyr":
                        if (String.valueOf(pair.getValue()).length() == 4) {
                            if (((Integer.parseInt((String) pair.getValue())) >= 2010) && ((Integer.parseInt((String) pair.getValue())) <= 2020)) {
                                valid = true;
                            } else {
                                continue outerloop;
                            }
                        } else {
                            continue outerloop;
                        }
                        break;
                    case "eyr":
                        if (String.valueOf(pair.getValue()).length() == 4) {
                            if (((Integer.parseInt((String) pair.getValue())) >= 2020) && ((Integer.parseInt((String) pair.getValue())) <= 2030)) {
                                valid = true;
                            } else {
                                continue outerloop;
                            }
                        } else {
                            continue outerloop;
                        }
                        break;
                    case "hgt":
                        if (String.valueOf(pair.getValue()).endsWith("cm")) {
                            String[] height = String.valueOf(pair.getValue()).split("cm");
                            if ((Integer.parseInt(height[0]) >= 150) && (Integer.parseInt(height[0]) <= 193)) {
                                valid = true;
                            } else {
                                continue outerloop;
                            }
                        } else if (String.valueOf(pair.getValue()).endsWith("in")) {
                            String[] height = String.valueOf(pair.getValue()).split("in");
                            if ((Integer.parseInt(height[0]) >= 59) && (Integer.parseInt(height[0]) <= 76)) {
                                valid = true;
                            } else {
                                continue outerloop;
                            }
                        } else {
                            continue outerloop;
                        }
                        break;
                    case "hcl":
                        if (pair.getValue().toString().matches("#[a-fA-F_0-9]{6}")) {
                            valid = true;
                        } else {
                            continue outerloop;
                        }
                        break;
                    case "ecl":
                        if (pair.getValue().equals("amb") || pair.getValue().equals("blu") || pair.getValue().equals("brn") ||
                                pair.getValue().equals("gry") || pair.getValue().equals("grn") || pair.getValue().equals("hzl") ||
                                pair.getValue().equals("oth")) {
                            valid = true;
                        } else {
                            continue outerloop;
                        }
                        break;
                    case "pid":
                        if (pair.getValue().toString().matches("[0-9]{9}")) {
                            valid = true;
                        } else {
                            continue outerloop;
                        }
                        break;
                    default:
                }
            }

            if (valid) {
                realValidPassports.add(validPassport);
            }
        }
        return realValidPassports;
    }
}
