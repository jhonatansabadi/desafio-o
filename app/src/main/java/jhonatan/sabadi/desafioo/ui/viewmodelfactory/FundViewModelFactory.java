package jhonatan.sabadi.desafioo.ui.viewmodelfactory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import jhonatan.sabadi.desafioo.ui.viewmodel.FundViewModel;

public class FundViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public FundViewModelFactory(Application application) {
        this.application = application;
    }

    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FundViewModel.class)) {
            return (T) new FundViewModel(application);
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
