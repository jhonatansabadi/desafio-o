package jhonatan.sabadi.desafioo.service.datasource;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundDataSourceFactory extends DataSource.Factory<Integer, Fund> {

    private List<Fund> funds = new ArrayList<>();

    public FundDataSourceFactory(List<Fund> funds) {
        this.funds = funds;
    }

    @NonNull
    @Override
    public DataSource<Integer, Fund> create() {
        return new FundDataSource(funds);
    }
}
