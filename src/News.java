import com.google.gson.annotations.SerializedName;
//import java.util.Date;
import java.util.List;

public class News{
    @SerializedName("_type")
    private String type;
    @SerializedName("didUMean")
    private String didUMean;
    private int totalCount;
//    public List<Object> relatedSearch;
    private List<Value> value;

    public String getType() {
        return type;
    }
    public String getDidUMean() {
        return didUMean;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public Value getValue(int i) {
        return value.get(i);
    }
    public int getSize(){
        return value.size();
    }
}

 class Value{
    private String id;
    private String title;
    private String url;
    private String description;
    private String body;
    private String keywords;
    private String language;
    private boolean isSafe;
    private String datePublished;
    private Provider provider;
//    public Image image;

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public String getDescription() {
        return description;
    }
    public String getBody() {
        return body;
    }
    public String getKeywords() {
        return keywords;
    }
    public String getLanguage() {
        return language;
    }
    public boolean isIsSafe() {
        return isSafe;
    }
    public String getDatePublished() {
        return datePublished;
    }
    public Provider getProvider() {
        return provider;
    }
}

class Provider{
    private String name;

    public String getName() {
        return name;
    }
    
}
//class Image{
//    public String url;
//    public int height;
//    public int width;
//    public String thumbnail;
//    public int thumbnailHeight;
//    public int thumbnailWidth;
//    public String base64Encoding;
//    public Object name;
//    public Object title;
//    public Provider provider;
//    public Object imageWebSearchUrl;
//    public String webpageUrl;
//}


