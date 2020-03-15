package jhonatan.sabadi.desafioo.model;

public class StrategyVideo {
    private String description;
    private String title;
    private String url;
    private String published;
    private String youtube_id;
    private String thumbnail;
    private int id;
    private boolean enabled_for_tvorama;

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

    public String getYoutube_id() {
        return youtube_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getId() {
        return id;
    }

    public boolean isEnabled_for_tvorama() {
        return enabled_for_tvorama;
    }
}
