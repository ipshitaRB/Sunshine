package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        final String TAG_LIST = "list";
        final String TAG_TEMP = "temp";
        final String TAG_MAX = "max";
        Double maxTemp = 0.0;
        //The traversal is root(JSONObject)->list[dayIndex](JSONArray)->temp(JSONObject)->max(String)

        //Create JSONObject and pass weatherJsonStr to it.
        JSONObject jsonObj = new JSONObject(weatherJsonStr);

        //get JSON array node List . load it into JSONArray
        JSONArray listJSONArray = jsonObj.getJSONArray(TAG_LIST);
        // get temp node for dayIndex in list
        JSONObject temp = listJSONArray.getJSONObject(dayIndex).getJSONObject(TAG_TEMP);
        String maxTempString = temp.getString(TAG_MAX);
        maxTemp = Double.parseDouble(maxTempString);


        return maxTemp;
    }

}
