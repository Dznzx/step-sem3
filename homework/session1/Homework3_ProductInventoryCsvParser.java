/*
 * Week 2 Assignment - Problem 3: Product Inventory CSV Parser
 * Splits a "ProductName,SKU,Quantity" CSV line into fields and prints a
 * formatted record, or reports an invalid record.
 */
public class Homework3_ProductInventoryCsvParser {

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }

    private static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
    }
}
