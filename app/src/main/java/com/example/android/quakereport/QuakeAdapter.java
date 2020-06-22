package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ahmed Magdy on 6/14/2020.
 */

public class QuakeAdapter extends ArrayAdapter<Earthquakes> {
    public QuakeAdapter(Activity context, ArrayList<Earthquakes> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitemlayout, parent, false);
        }
        Earthquakes currentEarthquake = getItem(position);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitudeTextView);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getQuakeMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeTextView.setText(formatMag(currentEarthquake.getQuakeMagnitude()));
        String[] locations = currentEarthquake.getQuakeLocation().split("of");
        String offsetLocation = locations[0];
        TextView offsetLocationText = (TextView) listItemView.findViewById(R.id.offsetLocationTextView);
        offsetLocationText.setText(offsetLocation + "of");
        if (locations.length > 1) {
            String primaryLocation = locations[1];

            TextView primarylocationText = (TextView) listItemView.findViewById(R.id.primaryLocationTextView);

            primarylocationText.setText(primaryLocation);
        } else {
            String primaryLocation = locations[0];
            offsetLocationText.setText("near the");
            TextView primarylocationText = (TextView) listItemView.findViewById(R.id.primaryLocationTextView);

            primarylocationText.setText(primaryLocation);
        }

        long timeInMilliseconds = currentEarthquake.getQuakeDate();
        Date dateObject = new Date(timeInMilliseconds);
        String formattedDate = formatDate(dateObject);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateTextView);
        dateTextView.setText(formattedDate);
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.timeTextView);
        timeTextView.setText(formattedTime);
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMag(double mag) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(mag);
        return output;
    }

    private int getMagnitudeColor(double mag) {
        int color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        if (mag >= 0 && mag <= 2)
            color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        else if (mag > 2 && mag <= 3)
            color = ContextCompat.getColor(getContext(), R.color.magnitude2);
        else if (mag > 3 && mag <= 4)
            color = ContextCompat.getColor(getContext(), R.color.magnitude3);
        else if (mag > 4 && mag <= 5)
            color = ContextCompat.getColor(getContext(), R.color.magnitude4);
        else if (mag > 5 && mag <= 6)
            color = ContextCompat.getColor(getContext(), R.color.magnitude5);
        else if (mag > 6 && mag <= 7)
            color = ContextCompat.getColor(getContext(), R.color.magnitude6);
        else if (mag > 7 && mag <= 8)
            color = ContextCompat.getColor(getContext(), R.color.magnitude7);
        else if (mag > 8 && mag <= 9)
            color = ContextCompat.getColor(getContext(), R.color.magnitude8);
        else if (mag > 9 && mag <= 10)
            color = ContextCompat.getColor(getContext(), R.color.magnitude9);
        else if (mag > 10)
            color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        return color;

    }
}