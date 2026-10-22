import java.util.*;

abstract class StaffMember {
    private final String name;

    protected StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private final double hours;
    private final double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends StaffMember {
    private final double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StaffMember[] staff = new StaffMember[count];

        for (int i = 0; i < count; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String name = sc.next();
            switch (type) {
                case "FULLTIME":
                    staff[i] = new FullTimeStaff(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    staff[i] = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
                    break;
                case "INTERN":
                    staff[i] = new Intern(name, sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }
        sc.close();

        double totalPayroll = 0.0;
        for (StaffMember member : staff) {
            double pay = member.calculatePay();
            System.out.printf("%s: %.2f%n", member.getName(), pay);
            totalPayroll += pay;
        }
        System.out.printf( "Total Payroll: %.2f%n", totalPayroll);
    }
}
