package consultor.car;

public enum CarPriceCategory {

    ACCESSIBLE("Acessível (R$ 0 até R$ 90.000)", 0, 90000),
    INTERMEDIATE("Intermediário (R$ 90.000 até R$ 130.000)", 90000, 130000),
    PREMIUM("Premium (R$ 130.000 até R$ 180.000)", 130000, 180000),
    LUXURY("Luxo (R$ 180.000 até R$ 220.000)", 180000, 220000),
    HIGH_LUXURY("Alto Luxo (R$ 220.000 até R$ 300.000)", 220000, 300000),
    ELITE("Elite (R$ 300.000 até R$ 350.000)", 300000, 350000);


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
