/*
 * Category C - Problem 3: The Nickname Tag
 * Immutable: the full name is split once in the constructor into final
 * fields, and the nickname is built from those stored parts.
 */
public class Problem3_TheNicknameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}

class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
