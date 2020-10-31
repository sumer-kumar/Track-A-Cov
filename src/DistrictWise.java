
import java.util.List;


class Delta{
    private int confirmed;
    private int deceased;
    private int recovered;

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeceased() {
        return deceased;
    }

    public int getRecovered() {
        return recovered;
    }
    
}

 class DistrictData{
    private String district;
    private String notes;
    private int active;
    private int confirmed;
    private int deceased;
    private int recovered;
    private Delta delta;

    public String getDistrict() {
        return district;
    }

    public String getNotes() {
        return notes;
    }

    public int getActive() {
        return active;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeceased() {
        return deceased;
    }

    public int getRecovered() {
        return recovered;
    }

    public Delta getDelta() {
        return delta;
    }

 }

public class DistrictWise{
    private String state;
    private String statecode;
    private List<DistrictData> districtData;

    public String getState() {
        return state;
    }

    public String getStatecode() {
        return statecode;
    }

    public List<DistrictData> getDistrictData() {
        return districtData;
    }

}

