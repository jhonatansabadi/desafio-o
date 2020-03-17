package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class FundMainStrategy implements Serializable {
    private int id;
    private String explanation;
    private String name;
    private int fund_macro_strategy;

    public int getId() {
        return id;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getName() {
        return name;
    }

    public int getFund_macro_strategy() {
        return fund_macro_strategy;
    }
}
