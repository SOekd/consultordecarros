package consultor.car;

public enum CarOrigin {

    NATIONAL("Nacional"),
    IMPORTED("Importado");

    private final String displayName;

    CarOrigin(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CarOrigin findByDisplayName(String displayName) {
        for (CarOrigin carOrigin : values()) {
            if (carOrigin.getDisplayName().equalsIgnoreCase(displayName)) {
                return carOrigin;
            }
        }
        return null;
    }


}
