import java.util.*;
public class Problem4 {
    static class Locker{
        int id;
        private String code;
        Locker(int id, String code){
            this.id = id;
            this.code = code;
        }
        void changeCode(String old, String New){
            if(old.equals(code)){
                code = New;
                System.out.println("Code Changed Successfully");
            }
            else{
                System.out.println("Invalid Old Code");
            }
        }
    }
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}