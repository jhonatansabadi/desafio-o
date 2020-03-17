package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class PerformanceAudio  implements Serializable {
    private String reference_date;
    private String soundcloud_id;
    private String permalink_url;
    private int id;
    private String title;

    public String getReference_date() {
        return reference_date;
    }

    public String getSoundcloud_id() {
        return soundcloud_id;
    }

    public String getPermalink_url() {
        return permalink_url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
