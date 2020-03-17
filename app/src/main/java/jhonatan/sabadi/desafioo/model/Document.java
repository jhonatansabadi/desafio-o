package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class Document implements Serializable {
    private int position;
    private String document_type;
    private String name;
    private String document_url;

    public int getPosition() {
        return position;
    }

    public String getDocument_type() {
        return document_type;
    }

    public String getName() {
        return name;
    }

    public String getDocument_url() {
        return document_url;
    }



}
