package jhonatan.sabadi.desafioo.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.ui.viewmodel.FundViewModel;

public class MainActivity extends AppCompatActivity {

    private FundViewModel fundViewModel = ViewModelProviders.of(this).get(FundViewModel.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFunds();

    }

    private void loadFunds() {
        fundViewModel.getFunds().observe(this, funds -> {

        });
    }

}