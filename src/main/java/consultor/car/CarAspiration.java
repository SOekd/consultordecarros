package consultor.car;


public enum CarAspiration {

    ASPIRATED("Aspirado"),
    TURBO("Turbo");

    private final String displayName;

    CarAspiration(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarAspiration findByDisplayName(String displayName) {
        for (CarAspiration value : values()) {
            if (value.getDisplayName().equalsIgnoreCase(displayName)) {
                return value;
            }
        }
        return null;
    }

}
