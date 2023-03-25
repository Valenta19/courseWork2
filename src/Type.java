
public enum Type {
    DEFAULT("Дефолт"),
    WORK("рабочая"),
    PERSONAL("личная");
    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
