package jhonatan.sabadi.desafioo.ui.activity;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.interfaces.OnRecyclerClickListener;
import jhonatan.sabadi.desafioo.model.Fund;
import jhonatan.sabadi.desafioo.ui.adapter.FundAdapter;
import jhonatan.sabadi.desafioo.ui.viewmodel.FundViewModel;

public class MainActivity extends AppCompatActivity implements OnRecyclerClickListener {

    private FundViewModel fundViewModel = ViewModelProviders.of(this).get(FundViewModel.class);
    private FundAdapter fundAdapter;
    private RecyclerView fundRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFunds();

    }

    private void initRecyclerView(List<Fund> funds) {
        fundRecyclerView = findViewById(R.id.fundRecyclerView);
        fundRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fundRecyclerView.setHasFixedSize(true);
        fundAdapter = new FundAdapter(funds, this);
        fundRecyclerView.setAdapter(fundAdapter);
    }

    private void loadFunds() {
        fundViewModel.getFunds().observe(this, funds -> {
            if (funds != null) {
                initRecyclerView(funds);
            }
        });
    }

    @Override
    public void setOnRecyclerClick(View view, int position) {

    }
}