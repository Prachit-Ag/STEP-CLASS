public class Problem4 {
    private String color;
    private final String id;
    public Problem4(String id) {
        this.id = id;
        this.color = "RED";
    }
    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }
    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Problem4 t = new Problem4("TL-9");
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
    }
}