package jhonatan.sabadi.desafioo.model;

import java.lang.reflect.Array;
import java.util.List;

public class Fund {
    private int id;
    private String initial_date;
    private Array performance_audios;
    private String description_seo;
    private Operability operability;
    private String full_name;
    private Fees fees;
    private boolean is_closed;
    private String simple_name;
    private String target_fund;
    private List<Document> documents;
    private Specification specification;
    private boolean is_active;
    private String tax_classification;
    private String cnpj;
    private Description description;
    private List<PerformanceVideo> performance_videos;
    private String quota_date;
    private Benchmark benchmark;
    private boolean orama_standard;
    private String slug;
    private String volatility_12m;
    private StrategyVideo strategy_video;
    private Profitabilities profitabilities;
    private String closed_to_capture_explanation;
    private String net_patrimony_12m;
    private boolean is_closed_to_capture;
    private FundManager fund_manager;
}
