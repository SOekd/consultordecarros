package consultor.car;

public enum CarSize {

    SUBCOMPACT("Subcompacto"),
    COMPACT("Compacto"),
    MIDSIZE("Médio"),
    MID_COMPACT("Médio-compacto"),
    LARGE("Grande");

    private final String displayName;

    CarSize(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarSize findByDisplayName(String displayName) {
        for (CarSize carSize : values()) {
            if (carSize.getDisplayName().equalsIgnoreCase(displayName)) {
                return carSize;
            }
        }
        return null;
    }

}
