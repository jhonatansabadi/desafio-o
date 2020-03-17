package jhonatan.sabadi.desafioo.ui.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import jhonatan.sabadi.desafioo.controller.FundController;
import jhonatan.sabadi.desafioo.model.Fund;

public class FundViewModel extends AndroidViewModel {

    private FundController fundController;

    public FundViewModel(@NonNull Application application) {
        super(application);
        this.fundController = new FundController(application);
    }

    public LiveData<PagedList<Fund>> getFunds() {
        return fundController.getFunds();
    }

}
