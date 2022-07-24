import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
// Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/4800c8d8db7fa6b491891df6/latest/USD";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject jObject = root.getAsJsonObject();
        jObject = jObject.getAsJsonObject("conversion_rates");





// Accessing object
        String time = jsonobj.get("time_last_update_utc").getAsString();
         System.out.println(time);

        String r = jObject.get("EUR").toString();
        System.out.println(r);


    }
}