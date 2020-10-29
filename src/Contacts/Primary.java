package Contacts;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Primary{
    private String number;
    @SerializedName("number-tollfree") 
    private String numberTollfree;
    private String email;
    private String twitter;
    private String facebook;
    private List <String> media;

    public String getNumber() {
        return number;
    }

    public String getNumberTollfree() {
        return numberTollfree;
    }

    public String getEmail() {
        return email;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public List<String> getMedia() {
        return media;
    }
    
}
