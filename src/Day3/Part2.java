package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/Day3/trees.txt"));
        int rows = 0, columns = 0;
        String str;
        List<String> lineList = new ArrayList<>();
        while ((str = br.readLine()) != null && str.length() != 0) {
            rows++;
            columns = Math.max(columns, str.length());
            lineList.add(str);
        }

        char[][] trees = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String currentLine = lineList.get(i);
            int idx = 0;
            for (int j = 0; j < currentLine.length(); j++) {
                trees[i][j] = currentLine.charAt(idx++);
            }
        }
        int noOfTrees = traverseTree(trees, rows, columns);

        System.out.println("Number of Trees: " + noOfTrees);
    }

    public static int traverseTree(char[][] newTreeArray, int rows, int columns) {
        int noOfTrees = 0;

        for (int i = 0, j = 0; i < rows && j < columns; i += 1, j += 3) {
            char nextPosition = newTreeArray[i][j];
            if (newTreeArray[i][j] == '#') {
                noOfTrees++;
            }
            if (j == columns-1){
                j=-1;
            } else if (j == columns-2){
                j=-2;
            } else if (j == columns-3){
                j=-3;
            }
        }
        return noOfTrees;
    }
}
