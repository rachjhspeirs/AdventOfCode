package Day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            HashMap<String, ArrayList<String>> bags = readFile();
            ArrayList<String> targetBags = getTarget(bags);

            for (int i = 0; i < targetBags.size(); i++) {
                System.out.println(targetBags.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static HashMap<String, ArrayList<String>> readFile() throws IOException {
        HashMap<String,ArrayList<String>> bags = new HashMap<>();

        File file = new File("src/Day7/bags.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            String[] separateBags = line.split("contain");
            String[] innerBags = separateBags[1].split(", ");
            ArrayList<String> innerBagsArray = new ArrayList<>();
            for (int i = 0; i < innerBags.length; i++) {
                innerBagsArray.add(innerBags[i]);
            }
            bags.put(separateBags[0], innerBagsArray);
        }
        return bags;
    }

    public static ArrayList<String> getTarget(HashMap<String, ArrayList<String>> bags){

        String target = "shiny gold bag";

        ArrayList<String> targetBags = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : bags.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i).contains(target)){
                    targetBags.add(entry.getKey());
                }
            }
        }
        return targetBags;
    }

    public static void recursiveGold(HashMap<String, ArrayList<String>> bags, ArrayList<String> targets){

        int goldBags = 0;
        for (Map.Entry<String, ArrayList<String>> entry : bags.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                for (int j = 0; j < targets.size(); j++) {
                    if (entry.getValue().get(i).contains(targets.get(j))){

                    }

                }

            }

        }

    }
}
