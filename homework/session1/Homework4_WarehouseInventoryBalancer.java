/*
 * Week 1 Assignment - Problem 4: Warehouse Inventory Balancer
 * Compares total quantities between two warehouse sections and locates
 * the single highest quantity value across both, with its position.
 */
public class Homework4_WarehouseInventoryBalancer {

    public static void main(String[] args) {
        analyzeInventory(new int[] {20, 15, 30}, new int[] {25, 10, 30});
    }

    private static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = sumOf(sectionA);
        int totalB = sumOf(sectionB);
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + highestQuantity
                + " (" + highestSection + ", Item " + highestIndex + ")");
    }

    private static int sumOf(int[] quantities) {
        int total = 0;
        for (int quantity : quantities) {
            total += quantity;
        }
        return total;
    }
}
