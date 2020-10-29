
import java.util.List;


class Delta{
    public int confirmed;
    public int deceased;
    public int recovered;
}

 class DistrictData{
    public String district;
    public String notes;
    public int active;
    public int confirmed;
    public int deceased;
    public int recovered;
    public Delta delta;
}

public class DistrictWise{
    public String state;
    public String statecode;
    public List<DistrictData> districtData;
}

