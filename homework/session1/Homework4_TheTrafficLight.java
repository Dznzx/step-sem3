/*
 * Category C Assignment - Problem 4: The Traffic Light
 * The current color is private and only next() can advance it, cycling
 * RED -> GREEN -> YELLOW -> RED forever. ID is final.
 */
public class Homework4_TheTrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}

class TrafficLight {
    private final String id;
    private String color;

    TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    String getColor() {
        return color;
    }
}
