
public class Saved {
    private String title;
    private String body;
    private String description;
    private String source;
    private String url;

    public Saved(String title,String description, String body, String source, String url) {
        this.title = title;
        this.body = body;
        this.description = description;
        this.source = source;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }
    
    
}
