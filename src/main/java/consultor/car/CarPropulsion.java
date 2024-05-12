package consultor.car;

public enum CarPropulsion {

    COMBUSTION("Combustão"),
    HYBRID("Híbrida"),
    PLUG_IN_HYBRID("Híbrido plug-in"),
    MILD_HYBRID("Híbrido leve");

    CarPropulsion(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    private final String displayName;

    public static CarPropulsion findByDisplayName(String displayName) {
        for (CarPropulsion carPropulsion : values()) {
            if (carPropulsion.getDisplayName().equalsIgnoreCase(displayName.trim())) {
                return carPropulsion;
            }
        }
        return null;
    }

}
