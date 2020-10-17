import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            var url = "https://api.rootnet.in/covid19-in/stats/latest";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();
            /*
             * File f = new File(database.jason);
             * f.write(s);
             *
             * */

            Gson gson = new Gson();
            StateWise root = gson.fromJson(s, StateWise.class);
            System.out.printf("%-4s   %-25s  %-15s  %-15s  %-15s  ", "S.no", "Location", "Confirmed Cases", "Recovered", "Deaths");
            for (int i = 0; i < root.data.regional.size(); i++) {
                System.out.println();
                System.out.printf("%-4d  %-25s  %-15d  %-15d  %-15d  ", i, root.data.regional.get(i).loc,
                        root.data.regional.get(i).confirmedCasesIndian, root.data.regional.get(i).discharged,
                        root.data.regional.get(i).deaths);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
           System.out.println("No internet : :\\ ");

        }


        }

    }
