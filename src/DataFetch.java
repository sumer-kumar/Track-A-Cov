
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DataFetch {
private StateWise stateWiseObj;
private DistrictWise [] districtWiseObj;

    public DistrictWise[] getDistrictWiseObj() {
        return districtWiseObj;
    }
    
    public StateWise getStateWise() {
        return stateWiseObj;
    }
    public void refresh() throws Exception{
            URL url = new URL("https://api.rootnet.in/covid19-in/stats/latest");
            URLConnection urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            int i;
            String s="";
            while((i = is.read())!=-1){
                s = s+(char)i;
            }
            is.close();
            File offlineStateWise = new File("offlineStateWise.txt");
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(offlineStateWise));
            bfwriter.write(s);
            bfwriter.flush();
            bfwriter.close();
          try {
//                   refreshDistrict();     
                   fetchDataDistrict();
            } catch (Exception ex) {
                       System.out.println(ex.getMessage());
             }
                   
          
        }
     public void fetchData() {
        File offlineStateWise = new File("offlineStateWise.txt");
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
        stateWiseObj = gson.fromJson(s,StateWise.class);
    }catch(Exception e){
        e.getStackTrace();
    }
   
     }    
        public void refreshDistrict() throws Exception{
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
    }


