package History;

import java.util.Date;
import java.util.List;


public class History {
    public boolean success;
    public List <Datum> data;
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

class Datum{
    public String day;
    public Summary summary;
    public List <Regional> regional;
}

