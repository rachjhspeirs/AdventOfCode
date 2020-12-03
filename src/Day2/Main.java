package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<PasswordFormat> passwords = new ArrayList();

        File file = new File("src/Day2/passwords.txt");
        System.out.println(new File(".").getAbsoluteFile());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {

            PasswordFormat parsedPassword = parsePassword(line);
            passwords.add(parsedPassword);
        }

        Question1 q1 = new Question1();
        Question2 q2 = new Question2();

        int q1Counter = 0;
        for (int i = 0; i < passwords.size(); i++) {
            if (q1.checkValid(passwords.get(i))) {
                q1Counter++;
            }
        }

        int q2Counter = 0;
        for (int i = 0; i < passwords.size(); i++) {
            if (q2.checkValid(passwords.get(i))) {
                q2Counter++;
            }
        }
    }

    public static PasswordFormat parsePassword(String line) {

        int position1, position2;
        char letter;
        String password;
        String[] splitLine = line.split(" ");
        String[] boundaries = splitLine[0].split("-");

        position1 = Integer.parseInt(boundaries[0]);
        position2 = Integer.parseInt(boundaries[1]);
        char[] letterArray = splitLine[1].replace(":", "").toCharArray();
        letter = letterArray[0];
        password = splitLine[2];

        return new PasswordFormat(position1, position2, letter, password);
    }
}
