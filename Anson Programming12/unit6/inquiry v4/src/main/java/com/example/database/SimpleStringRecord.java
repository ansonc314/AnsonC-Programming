package com.example.database;

import javafx.beans.property.SimpleStringProperty;

public class SimpleStringRecord {
    public SimpleStringProperty Weight;
    public SimpleStringProperty BMI;
    public SimpleStringProperty SBP;

    public SimpleStringProperty DBP;

    public SimpleStringRecord(String Weight, String BMI, String SBP, String DBP) {
        this.Weight =new SimpleStringProperty(Weight);
        this.BMI = new SimpleStringProperty(BMI);
        this.SBP = new SimpleStringProperty(SBP);
        this.DBP = new SimpleStringProperty(DBP);
    }

    public String getWeight() {
        return Weight.get();
    }

    public SimpleStringProperty weightProperty() {
        return Weight;
    }

    public String getBMI() {
        return BMI.get();
    }

    public SimpleStringProperty BMIProperty() {
        return BMI;
    }

    public String getSBP() {
        return SBP.get();
    }



    public SimpleStringProperty SBPProperty() {
        return SBP;
    }

    public String getDBP() {
        return DBP.get();
    }

    public SimpleStringProperty DBPProperty() {
        return DBP;
    }

}
