
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
    
    public StateWise getStateWise() {
        return stateWiseObj;
    }
    public void refresh() throws Exception{
//        try {
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
            
//            lblLastRefreshed.setText(formatDateTime );
//            lblLastUpdated.setText("Last Updated:");
//        }catch(Exception e){
//           e.getStackTrace();
//           this.setVisible(true);
//        JOptionPane.showMessageDialog(this,"No Internet Connection\n"
//                +"Connect to Internet to See Latest Data");  
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
//        lblTotal.setText(""+stateWiseObj.data.summary.total);
//        lblActive.setText(""+(stateWiseObj.data.summary.total-stateWiseObj.data.summary.deaths-stateWiseObj.data.summary.discharged));
//        lblRecovered.setText(""+stateWiseObj.data.summary.discharged);
//        lblDeaths.setText(""+stateWiseObj.data.summary.deaths);
    }catch(Exception e){
        e.getStackTrace();
    }
     }    
        
    }


