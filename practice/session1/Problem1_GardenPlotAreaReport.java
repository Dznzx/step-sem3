/*
 * Problem 1: Garden Plot Area Report
 * Abstract Plot holds the owner; each shape implements area(). New shapes need no change to the report loop.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1_GardenPlotAreaReport {

    abstract static class Plot {
        protected final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract String shape();

        abstract double area();
    }

    static class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        String shape() { return "CIRCLE"; }
        double area() { return Math.PI * radius * radius; }
    }

    static class RectanglePlot extends Plot {
        private final double length;
        private final double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        String shape() { return "RECTANGLE"; }
        double area() { return length * width; }
    }

    static class TrianglePlot extends Plot {
        private final double base;
        private final double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        String shape() { return "TRIANGLE"; }
        double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            switch (shape) {
                case "CIRCLE": plots.add(new CirclePlot(owner, scanner.nextDouble())); break;
                case "RECTANGLE": plots.add(new RectanglePlot(owner, scanner.nextDouble(), scanner.nextDouble())); break;
                case "TRIANGLE": plots.add(new TrianglePlot(owner, scanner.nextDouble(), scanner.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown shape: " + shape);
            }
        }
        printReport(plots);
    }

    private static void printReport(List<Plot> plots) {
        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
