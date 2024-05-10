package consultor.car;

public enum CarSteeringType {

    ELECTRIC("Elétrica"),
    HYDRAULIC("Hidráulica"),
    ELECTROHYDRAULIC("Eletro-hidráulica");

    private final String displayName;

    CarSteeringType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarSteeringType findByDisplayName(String displayName) {
        for (CarSteeringType steeringType : values()) {
            if (steeringType.getDisplayName().equalsIgnoreCase(displayName)) {
                return steeringType;
            }
        }
        return null;
    }

}
