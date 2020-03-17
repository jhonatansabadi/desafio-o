package jhonatan.sabadi.desafioo.service;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PositionalDataSource;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundDataSource extends PositionalDataSource<Fund> {

    private List<Fund> funds = new ArrayList<>();

    public FundDataSource(List<Fund> funds) {
        this.funds = funds;
    }

    private List<Fund> getFunds(int start, int end) {
        List<Fund> fundLimited = funds.subList(start, end);
        return fundLimited;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Fund> callback) {
        List<Fund> fundLimited = getFunds(params.requestedStartPosition, params.requestedLoadSize);
        callback.onResult(fundLimited, params.requestedStartPosition, fundLimited.size());
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Fund> callback) {
        List<Fund> fundLimited = getFunds(params.startPosition, params.loadSize);
        callback.onResult(fundLimited);
    }
}
