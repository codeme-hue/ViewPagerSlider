package id.kardihaekal.viewpagerslider.model;

public class ItemObj {
    private String imageURL;
    private String accentColor;
    private String title;

    public ItemObj(String imageURL, String accentColor, String title) {
        this.imageURL = imageURL;
        this.accentColor = accentColor;
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public void setAccentColor(String accentColor) {
        this.accentColor = accentColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
