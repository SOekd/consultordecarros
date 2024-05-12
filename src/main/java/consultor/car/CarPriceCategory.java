package consultor.car;

public enum CarPriceCategory {

    CHEAP("Barato (menos de 120.000", Double.MIN_VALUE, 120000),
    MEDIUM("Medio (120.000 - 240.000)", 120000, 240000),
    EXPENSIVE("Caro (240.000 - 360.000)", 240000, 360000),
    LUXURY("Luxo (más de 360.000)", 360000, Double.MAX_VALUE);

    private final String displayName;

    private final double minimumPrice;

    private final double maximumPrice;

    CarPriceCategory(String displayName, double minimumPrice, double maximumPrice) {
        this.displayName = displayName;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public double getMaximumPrice() {
        return maximumPrice;
    }

    public static CarPriceCategory fromPrice(double price) {
        for (CarPriceCategory category : values()) {
            if (price >= category.minimumPrice && price < category.maximumPrice) {
                return category;
            }
        }
        return null;
    }

}
