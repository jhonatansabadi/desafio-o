package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class PerformanceVideo implements Serializable {
    private String description;
    private String title;
    private String url;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getPublished() {
        return published;
    }

    public String getEnabled_for_tvorama() {
        return enabled_for_tvorama;
    }

    public String getYoutube_id() {
        return youtube_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getId() {
        return id;
    }

    private String published;
    private String enabled_for_tvorama;
    private String youtube_id;
    private String thumbnail;
    private int id;
}
