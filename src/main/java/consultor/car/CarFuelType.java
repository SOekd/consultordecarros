package consultor.car;

public enum CarFuelType {

    FLEX("Flex"),
    GASOLINE("Gasolina"),
    DIESEL("Diesel");

    private final String displayName;

    CarFuelType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarFuelType findByDisplayName(String displayName) {
        for (CarFuelType carFuelType : values()) {
            if (carFuelType.getDisplayName().equalsIgnoreCase(displayName)) {
                return carFuelType;
            }
        }
        return null;
    }

}
