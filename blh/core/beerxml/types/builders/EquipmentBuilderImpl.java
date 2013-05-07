package blh.core.beerxml.types.builders;

import blh.core.beerxml.types.Equipment;
import blh.core.units.Percentage;
import blh.core.units.time.Minutes;
import blh.core.units.volume.Liters;
import blh.core.units.weight.Kilograms;

public class EquipmentBuilderImpl implements Builder<Equipment>, EquipmentBuilder {

    private String name;
    private Liters boilSize;
    private Liters batchSize;
    private Liters tunVolume;
    private Kilograms tunWeight;
    private double tunSpecificHeat;
    private Liters topUpWater;
    private Liters trubChillerLoss;
    private Percentage evapRate;
    private Minutes boilTime;
    private boolean calculatedBoilVolume;
    private Liters lauterDeadSpace;
    private Liters topUpKettle;
    private Percentage hopUtilization;
    private String notes;

    public EquipmentBuilderImpl() {
    }

    @Override
    public EquipmentBuilderImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setBoilSize(Liters boilSize) {
        this.boilSize = boilSize;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setBatchSize(Liters batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setTunVolume(Liters tunVolume) {
        this.tunVolume = tunVolume;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setTunWeight(Kilograms tunWeight) {
        this.tunWeight = tunWeight;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setTunSpecificHeat(double tunSpecificHeat) {
        this.tunSpecificHeat = tunSpecificHeat;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setTopUpWater(Liters topUpWater) {
        this.topUpWater = topUpWater;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setTrubChillerLoss(Liters trubChillerLoss) {
        this.trubChillerLoss = trubChillerLoss;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setEvapRate(Percentage evapRate) {
        this.evapRate = evapRate;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setBoilTime(Minutes boilTime) {
        this.boilTime = boilTime;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setCalculatedBoilVolume(boolean calculatedBoilVolume) {
        this.calculatedBoilVolume = calculatedBoilVolume;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setLauterDeadSpace(Liters lauterDeadSpace) {
        this.lauterDeadSpace = lauterDeadSpace;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setTopUpKettle(Liters topUpKettle) {
        this.topUpKettle = topUpKettle;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setHopUtilization(Percentage hopUtilization) {
        this.hopUtilization = hopUtilization;
        return this;
    }

    @Override
    public EquipmentBuilderImpl setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    @Override
    public EquipmentBuilderImpl set(String tagName, String value) {
        switch (tagName.toUpperCase()) {
            case "NAME":
                this.name = value;
                break;
            case "BOIL_SIZE":
                this.boilSize = new Liters(Double.parseDouble(value));
                break;
            case "BATCH_SIZE":
                this.batchSize = new Liters(Double.parseDouble(value));
                break;
            case "TUN_VOLUME":
                this.tunVolume = new Liters(Double.parseDouble(value));
                break;
            case "TUN_WEIGHT":
                this.tunWeight = new Kilograms(Double.parseDouble(value));
                break;
            case "TUN_SPECIFIC_HEAT":
                this.tunSpecificHeat = Double.parseDouble(value);
                break;
            case "TOP_UP_WATER":
                this.topUpWater = new Liters(Double.parseDouble(value));
                break;
            case "TRUB_CHILLER_LOSS":
                this.trubChillerLoss = new Liters(Double.parseDouble(value));
                break;
            case "EVAP_RATE":
                this.evapRate = new Percentage(Double.parseDouble(value));
                break;
            case "BOIL_TIME":
                this.boilTime = new Minutes(Integer.parseInt(value));
                break;
            case "CALC_BOIL_VOLUME":
                this.calculatedBoilVolume = Boolean.parseBoolean(value);
                break;
            case "LATUER_DEADSPACE":
                this.lauterDeadSpace = new Liters(Double.parseDouble(value));
                break;
            case "TOP_UP_KETTLE":
                this.topUpKettle = new Liters(Double.parseDouble(value));
                break;
            case "HOP_UTILIZATION":
                this.hopUtilization = new Percentage(Double.parseDouble(value));
                break;
            case "NOTES":
                this.notes = value;
                break;
            default:
                System.out.println("Unknown equipment value: " + value);
                break;
        }
        return this;
    }

    @Override
    public Equipment create() {
        return new Equipment(name, boilSize, batchSize, tunVolume, tunWeight, tunSpecificHeat, topUpWater, trubChillerLoss, evapRate, boilTime, calculatedBoilVolume, lauterDeadSpace, topUpKettle, hopUtilization, notes);
    }
}
