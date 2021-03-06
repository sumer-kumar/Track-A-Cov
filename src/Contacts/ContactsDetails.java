package Contacts;

import com.google.gson.annotations.SerializedName;

public class ContactsDetails {
    private boolean success;
    private Data data;
    private String lastRefreshed;
    private String lastOriginUpdate;  

    public boolean isSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }
    
}





