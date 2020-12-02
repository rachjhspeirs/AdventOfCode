public class Question1 {

    public static boolean checkValid(PasswordFormat pf){
        int count = 0;

        for (int i = 0; i < pf.getPassword().length(); i++) {
            if(pf.getPassword().charAt(i) == pf.getLetter()) {
                count++;
            }
        }

        return count >= pf.getPosition1() && count <= pf.getPosition2();
    }
}
