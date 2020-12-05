package Day5;

import java.io.*;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) {
        try {
            ArrayList<String> boardingPasses = readFile();
            ArrayList<Integer> IDs = getSeat(boardingPasses);
            int highestID = getHighestID(IDs);

            System.out.println("Highest ID: " + highestID);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFile() throws IOException {
        ArrayList<String> boardingPasses = new ArrayList();

        File file = new File("src/Day5/boardingpasses.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            boardingPasses.add(line);
        }
        return boardingPasses;
    }

    public static ArrayList<Integer> getSeat(ArrayList<String> boardingPasses){
        ArrayList<Integer> IDs = new ArrayList<>();

        for (String boardingPass : boardingPasses) {

            int rowNumber = binarySearchRowNumber(boardingPass.toCharArray(), 0, 127, 0);
            int seatNumber = binarySearchSeatNumber(boardingPass.substring(7).toCharArray(), 0, 7, 0);

            int ID = rowNumber * 8 + seatNumber;
            IDs.add(ID);
        }
        return IDs;
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

    public static int getHighestID(ArrayList<Integer> allIDs){
        int maxID = allIDs.get(0);
        for (int i = 0; i < allIDs.size(); i++) {
            if (allIDs.get(i) > maxID){
                maxID = allIDs.get(i);
            }
        }
        return maxID;
    }
}
