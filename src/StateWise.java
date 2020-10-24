import java.util.List;

public class StateWise{
    public boolean success;
    public Data data;
    public String lastRefreshed;
    public String lastOriginUpdate;

}
 class Summary{
    public int total;
    public int confirmedCasesIndian;
    public int confirmedCasesForeign;
    public int discharged;
    public int deaths;
    public int confirmedButLocationUnidentified;

}


 class Regional{
    public String loc;
    public int confirmedCasesIndian;
    public int confirmedCasesForeign;
    public int discharged;
    public int deaths;
    public int totalConfirmed;

 }

 class Data{
    public Summary summary;
    public List <Regional> regional;
    
 }



