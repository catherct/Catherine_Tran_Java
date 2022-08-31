package com.company;

public class AccountRecord {

    // properties
    private int charge;
    private String chargeDate;


    // getters and setters
    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    @Override
    public String toString() {
        return "AccountRecord{" +
                "charge=" + charge +
                ", chargeDate='" + chargeDate + '\'' +
                '}';
    }
}
