package jhonatan.sabadi.desafioo.model;

public class Specification {
    private FundMacroStrategy fund_suitability_profile;
    private FundMacroStrategy fund_risk_profile;
    private boolean is_qualified;

    public FundMacroStrategy getFund_suitability_profile() {
        return fund_suitability_profile;
    }

    public FundMacroStrategy getFund_risk_profile() {
        return fund_risk_profile;
    }

    public boolean isIs_qualified() {
        return is_qualified;
    }

    public String getFund_type() {
        return fund_type;
    }

    public String getFund_class() {
        return fund_class;
    }

    public FundMacroStrategy getFund_macro_strategy() {
        return fund_macro_strategy;
    }

    public FundMainStrategy getFund_main_strategy() {
        return fund_main_strategy;
    }

    private String fund_type;
    private String fund_class;
    private FundMacroStrategy fund_macro_strategy;
    private FundMainStrategy fund_main_strategy;
}
