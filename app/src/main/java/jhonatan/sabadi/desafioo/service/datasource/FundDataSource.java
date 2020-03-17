package jhonatan.sabadi.desafioo.service.datasource;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PositionalDataSource;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundDataSource extends ItemKeyedDataSource<Integer, Fund> {

    private List<Fund> funds = new ArrayList<>();

    public FundDataSource(List<Fund> funds) {
        this.funds = funds;
    }

    private List<Fund> getFunds(int start, int end) {
        List<Fund> fundLimited = funds.subList(start, end);
        return fundLimited;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Fund> callback) {
        List<Fund> fundLimited = getFunds(0, params.requestedLoadSize);
        callback.onResult(fundLimited, 0, params.requestedLoadSize);
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Fund> callback) {
        List<Fund> fundLimited = getFunds(params.requestedLoadSize, params.requestedLoadSize + 30);
        callback.onResult(fundLimited);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Fund> callback) {
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Fund item) {
        return item.getId();
    }
}
