package consultor.car;

import java.util.List;
import java.util.Objects;

public class PseudoCar {

    private Double minimumPrice;

    private Double maximumPrice;

    private List<CarSize> size;

    private List<CarConfiguration> configuration;

    private List<CarAspiration> aspiration;

    private Double autonomy;

    private Double minimumAutonomy;

    private Double maximumAutonomy;

    private Double minimumConsumption;

    private Double maximumConsumption;

    private Double minimumAcceleration;

    private Double maximumAcceleration;

    private List<CarFuelType> fuelType;

    private List<CarTransmission> transmission;

    private List<CarSteeringType> steeringType;

    private List<CarTraction> traction;

    private List<CarPropulsion> propulsion;

    private Integer minimumWarranty;

    private Integer maximumWarranty;

    private Integer minimumSeats;

    private Integer maximumSeats;

    private Integer minimumTrunk;

    private Integer maximumTrunk;

    private List<CarOrigin> origin;

    private List<CarSeatType> seatType;

    public PseudoCar() {

    }

    public PseudoCar(Double minimumPrice, Double maximumPrice, List<CarSize> size, List<CarConfiguration> configuration, List<CarAspiration> aspiration, Double autonomy, Double minimumAutonomy, Double maximumAutonomy, Double minimumConsumption, Double maximumConsumption, Double minimumAcceleration, Double maximumAcceleration, List<CarFuelType> fuelType, List<CarTransmission> transmission, List<CarSteeringType> steeringType, List<CarTraction> traction, List<CarPropulsion> propulsion, Integer minimumWarranty, Integer maximumWarranty, Integer minimumSeats, Integer maximumSeats, Integer minimumTrunk, Integer maximumTrunk, List<CarOrigin> origin, List<CarSeatType> seatType) {
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
        this.size = size;
        this.configuration = configuration;
        this.aspiration = aspiration;
        this.autonomy = autonomy;
        this.minimumAutonomy = minimumAutonomy;
        this.maximumAutonomy = maximumAutonomy;
        this.minimumConsumption = minimumConsumption;
        this.maximumConsumption = maximumConsumption;
        this.minimumAcceleration = minimumAcceleration;
        this.maximumAcceleration = maximumAcceleration;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.steeringType = steeringType;
        this.traction = traction;
        this.propulsion = propulsion;
        this.minimumWarranty = minimumWarranty;
        this.maximumWarranty = maximumWarranty;
        this.minimumSeats = minimumSeats;
        this.maximumSeats = maximumSeats;
        this.minimumTrunk = minimumTrunk;
        this.maximumTrunk = maximumTrunk;
        this.origin = origin;
        this.seatType = seatType;
    }

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Double getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(Double maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public List<CarSize> getSize() {
        return size;
    }

    public void setSize(List<CarSize> size) {
        this.size = size;
    }

    public List<CarConfiguration> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<CarConfiguration> configuration) {
        this.configuration = configuration;
    }

    public List<CarAspiration> getAspiration() {
        return aspiration;
    }

    public void setAspiration(List<CarAspiration> aspiration) {
        this.aspiration = aspiration;
    }

    public Double getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(Double autonomy) {
        this.autonomy = autonomy;
    }

    public Double getMinimumAutonomy() {
        return minimumAutonomy;
    }

    public void setMinimumAutonomy(Double minimumAutonomy) {
        this.minimumAutonomy = minimumAutonomy;
    }

    public Double getMaximumAutonomy() {
        return maximumAutonomy;
    }

    public void setMaximumAutonomy(Double maximumAutonomy) {
        this.maximumAutonomy = maximumAutonomy;
    }

    public Double getMinimumConsumption() {
        return minimumConsumption;
    }

    public void setMinimumConsumption(Double minimumConsumption) {
        this.minimumConsumption = minimumConsumption;
    }

    public Double getMaximumConsumption() {
        return maximumConsumption;
    }

    public void setMaximumConsumption(Double maximumConsumption) {
        this.maximumConsumption = maximumConsumption;
    }

    public Double getMinimumAcceleration() {
        return minimumAcceleration;
    }

    public void setMinimumAcceleration(Double minimumAcceleration) {
        this.minimumAcceleration = minimumAcceleration;
    }

    public Double getMaximumAcceleration() {
        return maximumAcceleration;
    }

    public void setMaximumAcceleration(Double maximumAcceleration) {
        this.maximumAcceleration = maximumAcceleration;
    }

    public List<CarFuelType> getFuelType() {
        return fuelType;
    }

    public void setFuelType(List<CarFuelType> fuelType) {
        this.fuelType = fuelType;
    }

    public List<CarTransmission> getTransmission() {
        return transmission;
    }

    public void setTransmission(List<CarTransmission> transmission) {
        this.transmission = transmission;
    }

    public List<CarSteeringType> getSteeringType() {
        return steeringType;
    }

    public void setSteeringType(List<CarSteeringType> steeringType) {
        this.steeringType = steeringType;
    }

    public List<CarTraction> getTraction() {
        return traction;
    }

    public void setTraction(List<CarTraction> traction) {
        this.traction = traction;
    }

    public List<CarPropulsion> getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(List<CarPropulsion> propulsion) {
        this.propulsion = propulsion;
    }

    public Integer getMinimumWarranty() {
        return minimumWarranty;
    }

    public void setMinimumWarranty(Integer minimumWarranty) {
        this.minimumWarranty = minimumWarranty;
    }

    public Integer getMaximumWarranty() {
        return maximumWarranty;
    }

    public void setMaximumWarranty(Integer maximumWarranty) {
        this.maximumWarranty = maximumWarranty;
    }

    public Integer getMinimumSeats() {
        return minimumSeats;
    }

    public void setMinimumSeats(Integer minimumSeats) {
        this.minimumSeats = minimumSeats;
    }

    public Integer getMaximumSeats() {
        return maximumSeats;
    }

    public void setMaximumSeats(Integer maximumSeats) {
        this.maximumSeats = maximumSeats;
    }

    public Integer getMinimumTrunk() {
        return minimumTrunk;
    }

    public void setMinimumTrunk(Integer minimumTrunk) {
        this.minimumTrunk = minimumTrunk;
    }

    public Integer getMaximumTrunk() {
        return maximumTrunk;
    }

    public void setMaximumTrunk(Integer maximumTrunk) {
        this.maximumTrunk = maximumTrunk;
    }

    public List<CarOrigin> getOrigin() {
        return origin;
    }

    public void setOrigin(List<CarOrigin> origin) {
        this.origin = origin;
    }

    public List<CarSeatType> getSeatType() {
        return seatType;
    }

    public void setSeatType(List<CarSeatType> seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PseudoCar pseudoCar = (PseudoCar) o;
        return Objects.equals(minimumPrice, pseudoCar.minimumPrice) && Objects.equals(maximumPrice, pseudoCar.maximumPrice) && Objects.equals(size, pseudoCar.size) && Objects.equals(configuration, pseudoCar.configuration) && Objects.equals(aspiration, pseudoCar.aspiration) && Objects.equals(autonomy, pseudoCar.autonomy) && Objects.equals(minimumAutonomy, pseudoCar.minimumAutonomy) && Objects.equals(maximumAutonomy, pseudoCar.maximumAutonomy) && Objects.equals(minimumConsumption, pseudoCar.minimumConsumption) && Objects.equals(maximumConsumption, pseudoCar.maximumConsumption) && Objects.equals(minimumAcceleration, pseudoCar.minimumAcceleration) && Objects.equals(maximumAcceleration, pseudoCar.maximumAcceleration) && Objects.equals(fuelType, pseudoCar.fuelType) && Objects.equals(transmission, pseudoCar.transmission) && Objects.equals(steeringType, pseudoCar.steeringType) && Objects.equals(traction, pseudoCar.traction) && Objects.equals(propulsion, pseudoCar.propulsion) && Objects.equals(minimumWarranty, pseudoCar.minimumWarranty) && Objects.equals(maximumWarranty, pseudoCar.maximumWarranty) && Objects.equals(minimumSeats, pseudoCar.minimumSeats) && Objects.equals(maximumSeats, pseudoCar.maximumSeats) && Objects.equals(minimumTrunk, pseudoCar.minimumTrunk) && Objects.equals(maximumTrunk, pseudoCar.maximumTrunk) && Objects.equals(origin, pseudoCar.origin) && Objects.equals(seatType, pseudoCar.seatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumPrice, maximumPrice, size, configuration, aspiration, autonomy, minimumAutonomy, maximumAutonomy, minimumConsumption, maximumConsumption, minimumAcceleration, maximumAcceleration, fuelType, transmission, steeringType, traction, propulsion, minimumWarranty, maximumWarranty, minimumSeats, maximumSeats, minimumTrunk, maximumTrunk, origin, seatType);
    }

    @Override
    public String toString() {
        return "PseudoCar{" +
                "minimumPrice=" + minimumPrice +
                ", maximumPrice=" + maximumPrice +
                ", size=" + size +
                ", configuration=" + configuration +
                ", aspiration=" + aspiration +
                ", autonomy=" + autonomy +
                ", minimumAutonomy=" + minimumAutonomy +
                ", maximumAutonomy=" + maximumAutonomy +
                ", minimumConsumption=" + minimumConsumption +
                ", maximumConsumption=" + maximumConsumption +
                ", minimumAcceleration=" + minimumAcceleration +
                ", maximumAcceleration=" + maximumAcceleration +
                ", fuelType=" + fuelType +
                ", transmission=" + transmission +
                ", steeringType=" + steeringType +
                ", traction=" + traction +
                ", propulsion=" + propulsion +
                ", minimumWarranty=" + minimumWarranty +
                ", maximumWarranty=" + maximumWarranty +
                ", minimumSeats=" + minimumSeats +
                ", maximumSeats=" + maximumSeats +
                ", minimumTrunk=" + minimumTrunk +
                ", maximumTrunk=" + maximumTrunk +
                ", origin=" + origin +
                ", seatType=" + seatType +
                '}';
    }

    @Override
    public PseudoCar clone()  {
        return new PseudoCar(
                minimumPrice,
                maximumPrice,
                size,
                configuration,
                aspiration,
                autonomy,
                minimumAutonomy,
                maximumAutonomy,
                minimumConsumption,
                maximumConsumption,
                minimumAcceleration,
                maximumAcceleration,
                fuelType,
                transmission,
                steeringType,
                traction,
                propulsion,
                minimumWarranty,
                maximumWarranty,
                minimumSeats,
                maximumSeats,
                minimumTrunk,
                maximumTrunk,
                origin,
                seatType
        );
    }
}
