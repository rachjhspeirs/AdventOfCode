package Day2;

public class Part2 {

    public static boolean checkValid(PasswordFormat pf) {
        int count = 0;

        for (int i = 0; i < pf.getPassword().length(); i++) {
            if (pf.getPassword().charAt(pf.getPosition1() - 1) == pf.getLetter()) {
                if (pf.getPassword().charAt(pf.getPosition2() - 1) != pf.getLetter()) {
                    count++;
                    break;
                }
            } else if (pf.getPassword().charAt(pf.getPosition2() - 1) == pf.getLetter()) {
                count++;
                break;
            }
        }
        return count == 1;
    }
}
