package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class FundStrategy  implements Serializable {
    private int id;
    private String explanation;
    private String name;

    public int getId() {
        return id;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getName() {
        return name;
    }
}
