/*
 * Category C Assignment - Problem 5: The Shopping Cart
 * Item prices are private; getTotal() and getItemCount() are computed
 * on request from the internal array, which is never exposed directly.
 */
public class Homework5_TheShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}

class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    void addItem(double price) {
        if (itemCount >= prices.length) {
            return;
        }
        prices[itemCount] = price;
        itemCount++;
    }

    double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return itemCount;
    }
}
