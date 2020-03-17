package jhonatan.sabadi.desafioo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import androidx.room.Entity;


public class Fund implements Serializable {
    private int id;
    private String initial_date;


    private List<PerformanceAudio> performance_audios;
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
    private List<PerformanceVideo> performance_videos;

    public List<PerformanceVideo> getPerformance_videos() {
        return performance_videos;
    }

    public List<PerformanceAudio> getPerformance_audios() {
        return performance_audios;
    }

    public int getId() {
        return id;
    }

    public String getInitial_date() {
        return initial_date;
    }

    public String getDescription_seo() {
        return description_seo;
    }

    public Operability getOperability() {
        return operability;
    }

    public String getFull_name() {
        return full_name;
    }

    public Fees getFees() {
        return fees;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public String getSimple_name() {
        return simple_name;
    }

    public String getTarget_fund() {
        return target_fund;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public Specification getSpecification() {
        return specification;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public String getTax_classification() {
        return tax_classification;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Description getDescription() {
        return description;
    }


    public String getQuota_date() {
        return quota_date;
    }

    public Benchmark getBenchmark() {
        return benchmark;
    }

    public boolean isOrama_standard() {
        return orama_standard;
    }

    public String getSlug() {
        return slug;
    }

    public String getVolatility_12m() {
        return volatility_12m;
    }

    public StrategyVideo getStrategy_video() {
        return strategy_video;
    }

    public Profitabilities getProfitabilities() {
        return profitabilities;
    }

    public String getClosed_to_capture_explanation() {
        return closed_to_capture_explanation;
    }

    public String getNet_patrimony_12m() {
        return net_patrimony_12m;
    }

    public boolean isIs_closed_to_capture() {
        return is_closed_to_capture;
    }

    public FundManager getFund_manager() {
        return fund_manager;
    }

}
