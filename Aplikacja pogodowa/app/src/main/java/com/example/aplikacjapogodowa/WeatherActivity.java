package com.example.aplikacjapogodowa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplikacjapogodowa.R;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {
//dodać w manifeście dostęp do internetu

    private EditText cityEditText;
    private Button searchButton;
    private ImageView weatherImageView;
    private TextView weatherInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityEditText = findViewById(R.id.city_edit_text);
        searchButton = findViewById(R.id.search_button);
        weatherImageView = findViewById(R.id.weather_image_view);
        weatherInfoTextView = findViewById(R.id.weather_info_text_view);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = cityEditText.getText().toString().trim();
                if (!cityName.isEmpty()) {
                    fetchWeatherData(cityName);
                }
            }
        });
    }

    private void fetchWeatherData(String cityName) {
        String apiKey = "eb299793d74ab49a459fdbf2815edeea";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey + "&lang=pl";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String weatherDescription = response.getJSONArray("weather").getJSONObject(0).getString("description");
                            String weatherIcon = response.getJSONArray("weather").getJSONObject(0).getString("icon");
                            String mainSection = response.getJSONObject("main").toString();
                            int visibility = response.getInt("visibility");
                            double windSpeed = response.getJSONObject("wind").getDouble("speed");
                            String rain = response.has("rain") ? response.getJSONObject("rain").toString() : "";
                            String snow = response.has("snow") ? response.getJSONObject("snow").toString() : "";
                            int clouds = response.getJSONObject("clouds").getInt("all");
                            String cityName = response.getString("name");


                            String weatherInfo = "Weather: " + weatherDescription + "\n" +
                                    "Main: " + mainSection + "\n" +
                                    "Visibility: " + visibility + "\n" +
                                    "Wind Speed: " + windSpeed + " m/s\n" +
                                    "Rain: " + rain + "\n" +
                                    "Snow: " + snow + "\n" +
                                    "Clouds: " + clouds + "%\n" +
                                    "City Name: " + cityName;

                            weatherInfoTextView.setText(weatherInfo);


                            int iconResourceId = getResources().getIdentifier("icon_" + weatherIcon, "drawable", getPackageName());
                            weatherImageView.setImageResource(iconResourceId);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> {
                    error.printStackTrace();
                    weatherInfoTextView.setText("Error");
                });

        requestQueue.add(jsonObjectRequest);
    }
}
