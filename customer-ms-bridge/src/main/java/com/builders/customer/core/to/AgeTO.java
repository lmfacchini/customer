package com.builders.customer.core.to;

public class AgeTO {

    private byte days;
    private byte months;
    private byte years;

    private AgeTO()
    {
        //Prevent default constructor
    }

    public AgeTO(byte days, byte months, byte years)
    {
        this.days = days;
        this.months = months;
        this.years = years;
    }

    public byte getDays()
    {
        return this.days;
    }

    public byte getMonths()
    {
        return this.months;
    }

    public byte getYears()
    {
        return this.years;
    }

    @Override
    public String toString()
    {
        return years + " Years, " + months + " Months, " + days + " Days";
    }
}
