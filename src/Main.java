
import History.History;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Main {
    static DistrictWise districtWiseObj;
    public static void main(String[] args) throws Exception {
        HomePage h = new HomePage();
        var url = "https://api.rootnet.in/covid19-in/stats/history";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();
            Gson gson = new Gson();
            History history = gson.fromJson(s, History.class);
        }

    }
     

    
