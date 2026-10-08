/*
 * Assignment Problem 2: Parcel Shipping Desk
 * Every parcel has a shipping charge (abstract class); insurance is a separate ability (Insurable interface)
 * so making another type insurable never touches the uninsured ones.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework2_ParcelShippingDesk {

    interface Insurable {
        double INSURANCE_RATE = 0.02;

        double insurance();
    }

    abstract static class Parcel {
        protected final double weightKg;
        protected final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract String type();

        abstract double charge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double w, double v) { super(w, v); }
        String type() { return "STANDARD"; }
        double charge() { return 40 + 10 * weightKg; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double w, double v) { super(w, v); }
        String type() { return "EXPRESS"; }
        double charge() { return 80 + 15 * weightKg; }
        public double insurance() { return declaredValue * INSURANCE_RATE; }
    }

    static class FragileParcel extends StandardParcel implements Insurable {
        FragileParcel(double w, double v) { super(w, v); }
        String type() { return "FRAGILE"; }
        double charge() { return super.charge() + 50; }
        public double insurance() { return declaredValue * INSURANCE_RATE; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();
            switch (type) {
                case "STANDARD": parcels.add(new StandardParcel(weight, value)); break;
                case "EXPRESS": parcels.add(new ExpressParcel(weight, value)); break;
                case "FRAGILE": parcels.add(new FragileParcel(weight, value)); break;
                default: throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
        }
        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.charge();
            double insurance = (parcel instanceof Insurable insurable) ? insurable.insurance() : 0;
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcel.type(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
