public class Problem3 {
    private final String password;
    public Problem3(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        Problem3 pc = new Problem3("abcd");
        System.out.println(pc.getStrength());
        Problem3 pc2 = new Problem3("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}