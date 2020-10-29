package History;

import java.util.Date;
import java.util.List;


public class History {
    private boolean success;
    private List <Datum> data;
    private String lastRefreshed;
    private String lastOriginUpdate;

    public boolean isSuccess() {
        return success;
    }
    public List<Datum> getData() {
        return data;
    }
    public String getLastRefreshed() {
        return lastRefreshed;
    }
    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    } 
}
    


