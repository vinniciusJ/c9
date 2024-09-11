package bd.c9.models;

public enum ClientType {
    INDIVIDUAL("Pessoa física"),
    LEGAL_ENTITY("Pessoa juridica");

    private final String label;

    ClientType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
