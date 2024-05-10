package consultor.car;

public enum CarSeatType {

    FABRIC("Tecido"),
    LEATHER("Couro");

    private final String displayName;

    CarSeatType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarSeatType findByDisplayName(String displayName) {
        for (CarSeatType carSeatType : values()) {
            if (carSeatType.getDisplayName().equalsIgnoreCase(displayName)) {
                return carSeatType;
            }
        }
        return null;
    }

}
