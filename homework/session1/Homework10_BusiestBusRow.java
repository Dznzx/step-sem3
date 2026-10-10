/*
 * Assignment Problem 10: Busiest Bus Row
 * Returns the row with the largest seat total; ties keep the smaller index
 * because the best row is only replaced on a strictly larger total.
 *
 * Time: O(r * c) — every seat is visited once. Extra space: O(1).
 */
public class Homework10_BusiestBusRow {

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }

    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int row = 0; row < grid.length; row++) {
            int total = 0;
            for (int seat : grid[row]) {
                total += seat;
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }
        return new int[] {bestRow, bestTotal};
    }
}
