package catapp.service;

import catapp.model.CatImage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiService {
    private static final String API_URL =
            "https://api.thecatapi.com/v1/images/search?limit=10&breed_ids=beng&api_key=live_TYpq3SM4KrAh4mKMYziF93YFjnpFmWQ4vwtzyZVDj6gSmfkXn4YfB5pU1yL1Cf75";

    public static List<CatImage> fetchCatImages() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
            return new Gson().fromJson(reader, new TypeToken<List<CatImage>>() {}.getType());
        }
    }
}
