package consultor.car;

public enum CarTraction {

    FRONT("Dianteira"),
    ON_DEMAND("Integral sob demanda"),
    TEMPORARY("Integral temporária");

    private final String displayName;

    CarTraction(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarTraction findByDisplayName(String displayName) {
        for (CarTraction value : values()) {
            if (value.getDisplayName().equalsIgnoreCase(displayName)) {
                return value;
            }
        }
        return null;
    }

}
