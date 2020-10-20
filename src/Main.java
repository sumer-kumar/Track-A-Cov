import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    static DistrictWise districtWiseObj;
    public static void main(String[] args) throws Exception {
        HomePage h = new HomePage();
//        refreshDistrict();
//        fetchDataDistrict();
//        
        
        }
     public static void refreshDistrict() throws Exception{
            URL url = new URL("https://api.covid19india.org/v2/state_district_wise.json");
            URLConnection urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            int i;
            String s="";
            while((i = is.read())!=-1){
                s = s+(char)i;
            }
            is.close();
            File offlineStateWise = new File("offlineDistrictWise.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
  
        }
        public static void fetchDataDistrict() {
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
        System.out.println("Boom");
        districtWiseObj = gson.fromJson(s,DistrictWise.class);
        System.out.println("Boom");
//        System.out.print("Boom"+districtWiseObj.myArray.get(5).state);
    }catch(Exception e){
       System.out.println(e.getMessage());
        System.out.println("Boom");
    }
     }

    }
