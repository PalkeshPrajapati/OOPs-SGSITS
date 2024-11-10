package inventory;

public class StockUpdater implements Runnable {
    private Product product;

    public StockUpdater(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // Simulate delay in stock update
            product.updateStock(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
