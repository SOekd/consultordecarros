package consultor.car;

public enum CarTransmission {

    MANUAL("Manual"),
    AUTOMATIC("Automático");

    private final String displayName;

    CarTransmission(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarTransmission findByDisplayName(String displayName) {
        for (CarTransmission carTransmission : values()) {
            if (carTransmission.getDisplayName().equalsIgnoreCase(displayName.trim())) {
                return carTransmission;
            }
        }
        return null;
    }

}
