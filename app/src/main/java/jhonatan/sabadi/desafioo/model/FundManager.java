package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class FundManager  implements Serializable {
    private int id;
    private String description;
    private String full_name;
    private String logo;
    private String slug;
    private String name;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getLogo() {
        return logo;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FundManager{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", full_name='" + full_name + '\'' +
                ", logo='" + logo + '\'' +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
