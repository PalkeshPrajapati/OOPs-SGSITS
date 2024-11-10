package inventory;

public class Supplier {
    private String name;
    private int supplierId;

    public Supplier(String name, int supplierId) {
        this.name = name;
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public int getSupplierId() {
        return supplierId;
    }
}
