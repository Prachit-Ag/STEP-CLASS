
import java.util.*;

abstract class Student {
    static final double TRANSPORT_FEE = 12000;
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getHostelFee() {
        return 0;
    }

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        return getTuition() + getHostelFee()
                + (usesBus() ? TRANSPORT_FEE : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    double getHostelFee() {
        return 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student = null;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
            }

            if (student != null) {
                double fee = student.getTotalFee();
                System.out.printf("%s: %.2f%n", name, fee);
                total += fee;
            }
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
