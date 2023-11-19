package mg.tiavina.store.models.exception;

public class QuantityException extends Exception {
    private static final String MSG = "La quantité ne peut pas être négative";
    private static final String MSG_QUANTITY = "La quantité ne peut pas être négative(Quantity=%s)";
    double quantity;
    double left;

    public QuantityException() {
        super(MSG);
    }

    public QuantityException(double quantity) {
        super(String.format(MSG_QUANTITY, quantity));
    }

    public QuantityException(double quantity, double left) {
        super(String.format(MSG_QUANTITY, quantity));
        this.quantity = quantity;
        this.left = left;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    

}
