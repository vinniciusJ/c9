package bd.c9.models;

public enum PaymentMethod {
    DEBIT("Débito"),
    CREDIT("Crédito");

    private final String label;

    PaymentMethod(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
