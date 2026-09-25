public class Problem3 {
    static class NameTag {
        private final String firstName;
        private final String lastName;
        NameTag(String fullName) {
            String[] nameParts = fullName.split(" ");
            firstName = nameParts[0];
            lastName = nameParts[1];
        }
        String getNickname() {
            return firstName + " " + lastName.charAt(0) + ".";
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}