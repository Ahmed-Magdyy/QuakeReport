package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by Ahmed Magdy on 6/19/2020.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquakes>> {
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    public List<Earthquakes> loadInBackground() {
        Log.i(EarthquakeLoader.class.getName(), "Loader reset");
        if (mUrl == null)
            return null;
        // Perform the HTTP request for earthquake data and process the response.
        // Log.v("EarthquakeLoader.this","Loader created");
        List<Earthquakes> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;

    }
}
