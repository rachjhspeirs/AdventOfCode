package Day5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<String> lines = readFile();
            ArrayList<Integer> allIDs = new ArrayList<>();
            ArrayList<BoardingPass> boardingPasses = getSeat(lines, allIDs);
            int highestID = getHighestID(boardingPasses);

            System.out.println("Highest ID: " + highestID);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFile() throws IOException {
        ArrayList<String> lines = new ArrayList();

        File file = new File("src/Day5/boardingpasses.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    public static ArrayList<BoardingPass> getSeat(ArrayList<String> lines, ArrayList<Integer> allIDs){
        ArrayList<BoardingPass> boardingPasses = new ArrayList<>();

        for (String boardingPass : lines) {

            int rowNumber = binarySearchRowNumber(boardingPass.toCharArray(), 0, 127, 0);
            int seatNumber = binarySearchSeatNumber(boardingPass.substring(7).toCharArray(), 0, 7, 0);
            int ID = rowNumber * 8 + seatNumber;
            BoardingPass bp = new BoardingPass(rowNumber, seatNumber, ID);
            boardingPasses.add(bp);
            allIDs.add(ID);

        }
        return boardingPasses;
    }

    public static int binarySearchRowNumber (char[] boardingPass, int l, int r, int x){

        int mid = l + (r-l)/2;

        if (boardingPass[x] == 'F'){
            return binarySearchRowNumber(boardingPass, l, mid, x+1);

        } else if (boardingPass[x] == 'B'){
            return binarySearchRowNumber(boardingPass,mid+1, r, x+1);
        }
        return mid;
    }

    public static int binarySearchSeatNumber(char[] boardingPass, int l, int r, int x){

        int mid = l + (r-l)/2;
        while(x!=boardingPass.length) {
            if (boardingPass[x] == 'L') {
                return binarySearchSeatNumber(boardingPass, l, mid, x + 1);

            } else if (boardingPass[x] == 'R') {
                return binarySearchSeatNumber(boardingPass, mid + 1, r, x + 1);
            }
        }
        return mid;
    }

    public static int getHighestID(ArrayList<BoardingPass> allBoardingPasses){
        int maxID = allBoardingPasses.get(0).getID();
        for (int i = 0; i < allBoardingPasses.size(); i++) {
            if (allBoardingPasses.get(i).getID() > maxID){
                maxID = allBoardingPasses.get(i).getID();
            }
        }
        return maxID;
    }
}
