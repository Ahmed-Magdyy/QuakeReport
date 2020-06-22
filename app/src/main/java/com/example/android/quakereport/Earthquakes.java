package com.example.android.quakereport;

/**
 * Created by Ahmed Magdy on 6/14/2020.
 */

public class Earthquakes {
    private double mQuakeMagnitude;
    private String mQuakeLocation;
    private long mQuakeDate;
    private String mQuakeURL;

    public Earthquakes(double magnitude, String location, long date, String quakeURL) {
        mQuakeMagnitude = magnitude;
        mQuakeLocation = location;
        mQuakeDate = date;
        mQuakeURL = quakeURL;
    }

    public double getQuakeMagnitude() {
        return mQuakeMagnitude;
    }

    public String getQuakeLocation() {
        return mQuakeLocation;
    }

    public long getQuakeDate() {
        return mQuakeDate;
    }

    public String getQuakeURL() {
        return mQuakeURL;
    }
}
