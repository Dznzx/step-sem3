/*
 * Practice 2: Instance vs Static (Class) Members
 * Demonstrate a shared static counter incremented once per object created,
 * versus per-instance fields that differ between objects.
 */
public class Problem2_InstanceVsStatic {
    public static void main(String[] args) {
        Counter first = new Counter("First");
        Counter second = new Counter("Second");
        Counter third = new Counter("Third");

        first.report();
        second.report();
        third.report();
    }
}

class Counter {
    private static int totalCreated = 0; // static: shared by all objects
    private final String label;          // instance: unique per object
    private final int creationOrder;

    Counter(String label) {
        this.label = label;
        totalCreated++;
        this.creationOrder = totalCreated;
    }

    void report() {
        System.out.println(label + " is object #" + creationOrder + " of " + totalCreated + " total");
    }
}
