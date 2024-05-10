package consultor.car;


public enum CarConfiguration {

    HATCH("Hatch"),
    SEDAN("Sedã"),
    SUV("SUV"),
    PICKUP("Picape"),
    MINIVAN("Minivan");

    private final String displayName;

    CarConfiguration(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarConfiguration findByDisplayName(String displayName) {
        for (CarConfiguration value : values()) {
            if (value.getDisplayName().equalsIgnoreCase(displayName)) {
                return value;
            }
        }
        return null;
    }

}
