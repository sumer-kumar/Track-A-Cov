import Advisories.Advisories;
import Contacts.ContactsDetails;
import History.History; //History Class imported
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class DataFetch {
//private StateWise stateWiseObj;
private DistrictWise [] districtWiseObj;
private History history;
private Advisories advisories;
private ContactsDetails contactDetails;

    public History getHistory() {
        return history;
    }
    public DistrictWise[] getDistrictWiseObj() {
        return districtWiseObj;
    }
//    public StateWise getStateWise() {
//        return stateWiseObj;
//    }
    public Advisories getAdvisories() {
        return advisories;
    }
    public ContactsDetails getContactDetails() {
        return contactDetails;
    }

        public void refreshDistrict() throws Exception{
//            URL url = new URL("https://api.covid19india.org/v2/state_district_wise.json");
            var url = "https://api.covid19india.org/v2/state_district_wise.json";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();
            File offlineStateWise = new File("offlineDistrictWise.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
  
        }
        public void fetchDataDistrict() {
        File offlineStateWise = new File("offlineDistrictWise.txt");
        BufferedReader bfreader;
    try {
        bfreader = new BufferedReader(new FileReader(offlineStateWise));
   
        String s = "";
        String endChecker;
        while((endChecker = bfreader.readLine())!=null){
            s+=endChecker;
        }
        bfreader.close();
        Gson gson = new Gson();
        System.out.println();
        districtWiseObj = gson.fromJson(s,DistrictWise[].class);
    }catch(Exception e){
        e.getStackTrace();
    }
     }
        public void refreshHistory()throws Exception{
            var url = "https://api.rootnet.in/covid19-in/stats/history";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();
            File offlineStateWise = new File("history.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
//            Gson gson = new Gson();
//            History h = gson.fromJson(s, History.class);

        }
        public void fetchHistory(){
        File offlineStateWise = new File("history.txt");
        BufferedReader bfreader;
        try {
        bfreader = new BufferedReader(new FileReader(offlineStateWise));
        String s = "";
        String endChecker;
        while((endChecker = bfreader.readLine())!=null){
            s+=endChecker;
        }
       bfreader.close();
       Gson gson = new Gson();
       history = gson.fromJson(s, History.class);
        }catch(Exception e){
        e.getStackTrace();
    }
        }
        public void refreshContacts()throws Exception{
            var url = "https://api.rootnet.in/covid19-in/contacts";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();
            File offlineStateWise = new File("Contacts.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
        }
        public void fetchContacts(){
        File offlineStateWise = new File("Contacts.txt");
        BufferedReader bfreader;
        try {
        bfreader = new BufferedReader(new FileReader(offlineStateWise));
        String s = "";
        String endChecker;
        while((endChecker = bfreader.readLine())!=null){
            s+=endChecker;
        }
       bfreader.close();
       Gson gson = new Gson();
       contactDetails = gson.fromJson(s, ContactsDetails.class);
        }catch(Exception e){
        e.getStackTrace();
    }
        }
        public void refreshAdvisories()throws Exception{
            var url = "https://api.rootnet.in/covid19-in/notifications";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();
            File offlineStateWise = new File("Advisories.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
        }
        public void fetchAdvisories(){
        File offlineStateWise = new File("Advisories.txt");
        BufferedReader bfreader;
        try {
        bfreader = new BufferedReader(new FileReader(offlineStateWise));
        String s = "";
        String endChecker;
        while((endChecker = bfreader.readLine())!=null){
            s+=endChecker;
        }
       bfreader.close();
       Gson gson = new Gson();
       advisories = gson.fromJson(s,Advisories.class);
        }catch(Exception e){
        e.getStackTrace();
    }
        }
    }

    
//        public void refresh() throws Exception{
//            URL url = new URL("https://api.rootnet.in/covid19-in/stats/latest");
//            URLConnection urlCon = url.openConnection();
//            InputStream is = urlCon.getInputStream();
//            int i;
//            String s="";
//            while((i = is.read())!=-1){
//                s = s+(char)i;
//            }
//            is.close();
//            File offlineStateWise = new File("offlineStateWise.txt");
//            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
//            bfwriter.write(s);
//            bfwriter.flush();
//            bfwriter.close();
////          try {
//////                   refreshDistrict();
////            } catch (Exception ex) {
////                       System.out.println(ex.getMessage());
////             }
//                   
//          
//        }
//        public void fetchData() {
//        File offlineStateWise = new File("offlineStateWise.txt");
//        BufferedReader bfreader;
//    try {
//        bfreader = new BufferedReader(new FileReader(offlineStateWise));
//   
//        String s = "";
//        String endChecker;
//        while((endChecker = bfreader.readLine())!=null){
//            s+=endChecker;
//        }
//        bfreader.close();
//        Gson gson = new Gson();
//        stateWiseObj = gson.fromJson(s,StateWise.class);
//    }catch(Exception e){
//        e.getStackTrace();
//    }   
//     }    
