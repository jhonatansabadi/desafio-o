package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class FundMacroStrategy implements Serializable {
    private int score_range_order;
    private String name;

    public int getScore_range_order() {
        return score_range_order;
    }

    public String getName() {
        return name;
    }
}
