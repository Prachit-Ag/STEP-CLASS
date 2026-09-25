public class Problem5 {
    private int[] prices;
    private int itemCount;
    private final String cartId;
    public Problem5(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new int[maxItems];
        itemCount = 0;
    }
    public void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }
    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Problem5 cart = new Problem5("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total = " + cart.getTotal());
        System.out.println("Item Count = " + cart.getItemCount());
    }
}