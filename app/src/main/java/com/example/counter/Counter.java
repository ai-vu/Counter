package com.example.counter;

public class Counter {
    private int minValue;
    private int maxValue;
    private int startValue;
    private int stepValue;
    private int currentValue;

    private boolean decimal = false;
    private boolean binary = false;
    private boolean hexadecimal = false;

    // A constructor with 4 parameters
    public Counter(int minValue, int maxValue, int startValue, int stepValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.startValue = startValue;
        this.stepValue = stepValue;
        this.currentValue = startValue;
    }

    // A constructor without parameters
    public Counter() {
        this.minValue = -100;
        this.maxValue = 100;
        this.startValue = 0;
        this.stepValue = 1;
        this.currentValue = startValue;
    }

    // Methods
    // Method for reset button
    public String getResetValue() {
        currentValue = this.startValue;
        return getValue();
    }

    // Method for minus button
    public String getMinusValue() {
        currentValue -= this.stepValue;
        if (currentValue < minValue) {
            // Assign current value as min value when under min
            currentValue = minValue;
        }
        return getValue();
    }

    // Method for plus button
    public String getPlusValue() {
        currentValue += this.stepValue;
        if (currentValue > maxValue) {
            // Assign current value as maximum value when over max
            currentValue = maxValue;
        }
        return getValue();
    }

    // Methods to activate the boolean decimal, binary, hexadecimal
    public void setDecimal() {
        decimal = true;
        binary = false;
        hexadecimal = false;
    }

    public void setBinary() {
        binary = true;
        decimal = false;
        hexadecimal = false;
    }

    public void setHexadecimal() {
        hexadecimal = true;
        binary = false;
        decimal = false;
    }

    // Methods to return current value (dec, bin, hex)
    public String getValue() {
        if (binary) {
            return Integer.toBinaryString(currentValue);
        } else if (hexadecimal) {
            return Integer.toHexString(currentValue);
        } else {
            return Integer.toString(currentValue);
        }
    }
}
