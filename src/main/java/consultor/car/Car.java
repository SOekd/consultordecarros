package consultor.car;

import java.util.Objects;

public class Car {
    private final String model;
    private final double price;
    private final CarSize size;
    private final CarConfiguration configuration;
    private final CarAspiration aspiration;
    private final double autonomy;
    private final double consumption;
    private final double acceleration;
    private final CarFuelType fuelType;
    private final CarTransmission transmission;
    private final CarSteeringType steeringType;
    private final CarTraction traction;
    private final CarPropulsion propulsion;
    private final int warranty;
    private final int seats;
    private final int trunk;
    private final CarOrigin origin;
    private final CarSeatType seatType;

    public Car(String model, double price, CarSize size, CarConfiguration configuration, CarAspiration aspiration, double autonomy, double consumption, double acceleration, CarFuelType fuelType, CarTransmission transmission, CarSteeringType steeringType, CarTraction traction, CarPropulsion propulsion, int warranty, int seats, int trunk, CarOrigin origin, CarSeatType seatType) {
        this.model = model;
        this.price = price;
        this.size = size;
        this.configuration = configuration;
        this.aspiration = aspiration;
        this.autonomy = autonomy;
        this.consumption = consumption;
        this.acceleration = acceleration;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.steeringType = steeringType;
        this.traction = traction;
        this.propulsion = propulsion;
        this.warranty = warranty;
        this.seats = seats;
        this.trunk = trunk;
        this.origin = origin;
        this.seatType = seatType;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public CarSize getSize() {
        return size;
    }

    public CarConfiguration getConfiguration() {
        return configuration;
    }

    public CarAspiration getAspiration() {
        return aspiration;
    }

    public double getAutonomy() {
        return autonomy;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public CarFuelType getFuelType() {
        return fuelType;
    }

    public CarTransmission getTransmission() {
        return transmission;
    }

    public CarSteeringType getSteeringType() {
        return steeringType;
    }

    public CarTraction getTraction() {
        return traction;
    }

    public CarPropulsion getPropulsion() {
        return propulsion;
    }

    public int getWarranty() {
        return warranty;
    }

    public int getSeats() {
        return seats;
    }

    public int getTrunk() {
        return trunk;
    }

    public CarOrigin getOrigin() {
        return origin;
    }

    public CarSeatType getSeatType() {
        return seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Double.compare(autonomy, car.autonomy) == 0 && Double.compare(consumption, car.consumption) == 0 && Double.compare(acceleration, car.acceleration) == 0 && warranty == car.warranty && seats == car.seats && trunk == car.trunk && Objects.equals(model, car.model) && size == car.size && configuration == car.configuration && aspiration == car.aspiration && fuelType == car.fuelType && transmission == car.transmission && steeringType == car.steeringType && traction == car.traction && propulsion == car.propulsion && origin == car.origin && seatType == car.seatType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, size, configuration, aspiration, autonomy, consumption, acceleration, fuelType, transmission, steeringType, traction, propulsion, warranty, seats, trunk, origin, seatType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", configuration=" + configuration +
                ", aspiration=" + aspiration +
                ", autonomy=" + autonomy +
                ", consumption=" + consumption +
                ", acceleration=" + acceleration +
                ", fuelType=" + fuelType +
                ", transmission=" + transmission +
                ", steeringType=" + steeringType +
                ", traction=" + traction +
                ", propulsion=" + propulsion +
                ", warranty=" + warranty +
                ", seats=" + seats +
                ", trunk=" + trunk +
                ", origin=" + origin +
                ", seatType=" + seatType +
                '}';
    }
}
