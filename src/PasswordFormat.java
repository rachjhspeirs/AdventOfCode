public class PasswordFormat {

    int position1;
    int position2;
    char letter;
    String password;

    public PasswordFormat(int position1, int position2, char letter, String password){

        this.position1 = position1;
        this.position2 = position2;
        this.letter = letter;
        this.password = password;

    }

    public int getPosition1() {
        return position1;
    }

    public int getPosition2() {
        return position2;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "PasswordFormat{" +
                "pos1=" + position1 +
                ", pos2=" + position2 +
                ", letter='" + letter + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}