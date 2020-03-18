package jhonatan.sabadi.desafioo.service.datasource;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundLiveDataPaged {

    private static PagedList.Config getPagedConfig() {
        return new PagedList.Config.Builder()
                .setInitialLoadSizeHint(5)
                .setPageSize(5)
                .setPrefetchDistance(5)
                .build();
    }

    public static synchronized LiveData<PagedList<Fund>> getInstanceLiveData(List<Fund> funds) {
        FundDataSourceFactory fundDataSourceFactory = new FundDataSourceFactory(funds);
        LiveData fundLiveData = new LivePagedListBuilder(fundDataSourceFactory, getPagedConfig()).build();
        return fundLiveData;
    }
}
