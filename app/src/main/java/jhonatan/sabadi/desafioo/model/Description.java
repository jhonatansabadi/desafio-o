package jhonatan.sabadi.desafioo.model;

import java.io.Serializable;

public class Description implements Serializable {
    private String objective;

    public String getObjective() {
        return objective;
    }

    public String getMovie_url() {
        return movie_url;
    }

    public String getTarget_audience() {
        return target_audience;
    }

    public String getStrengths() {
        return strengths;
    }

    public String getStrategy() {
        return strategy;
    }

    private String movie_url;
    private String target_audience;
    private String strengths;
    private String strategy;
}
