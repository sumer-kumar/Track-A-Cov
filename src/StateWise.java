import java.util.List;

public class StateWise{
    public boolean success;
    public Data data;
    public String lastRefreshed;
    public String lastOriginUpdate;

    public StateWise(boolean success, Data data, String lastRefreshed, String lastOriginUpdate) {
        this.success = success;
        this.data = data;
        this.lastRefreshed = lastRefreshed;
        this.lastOriginUpdate = lastOriginUpdate;
    }
}
 class Summary{
    public int total;
    public int confirmedCasesIndian;
    public int confirmedCasesForeign;
    public int discharged;
    public int deaths;
    public int confirmedButLocationUnidentified;

    public Summary(int total, int confirmedCasesIndian, int confirmedCasesForeign, int discharged, int deaths, int confirmedButLocationUnidentified) {
        this.total = total;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.confirmedCasesForeign = confirmedCasesForeign;
        this.discharged = discharged;
        this.deaths = deaths;
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }
}

 class UnofficialSummary{
    public String source;
    public int total;
    public int recovered;
    public int deaths;
    public int active;

     public UnofficialSummary(String source, int total, int recovered, int deaths, int active) {
         this.source = source;
         this.total = total;
         this.recovered = recovered;
         this.deaths = deaths;
         this.active = active;
     }
 }

 class Regional{
    public String loc;
    public int confirmedCasesIndian;
    public int confirmedCasesForeign;
    public int discharged;
    public int deaths;
    public int totalConfirmed;

     public Regional(String loc, int confirmedCasesIndian, int confirmedCasesForeign, int discharged, int deaths, int totalConfirmed) {
         this.loc = loc;
         this.confirmedCasesIndian = confirmedCasesIndian;
         this.confirmedCasesForeign = confirmedCasesForeign;
         this.discharged = discharged;
         this.deaths = deaths;
         this.totalConfirmed = totalConfirmed;
     }
 }

 class Data{
    public Summary summary;
    public List <UnofficialSummary> unofficial_summary;
    public List<Regional> regional;

     public Data(Summary summary, List<UnofficialSummary> unofficial_summary, List<Regional> regional) {
         this.summary = summary;
         this.unofficial_summary = unofficial_summary;
         this.regional = regional;
     }
 }



