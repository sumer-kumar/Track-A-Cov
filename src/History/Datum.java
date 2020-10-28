package History;

import java.util.List;

public class Datum{
    private String day;
    private Summary summary;
    private List <Regional> regional;

    public String getDay() {
        return day;
    }
    public Summary getSummary() {
        return summary;
    }
    public List <Regional> getRegional() {
        return regional;
    }
}