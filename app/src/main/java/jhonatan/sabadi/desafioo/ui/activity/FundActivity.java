package jhonatan.sabadi.desafioo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import java.io.Serializable;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.interfaces.OnRecyclerClickListener;
import jhonatan.sabadi.desafioo.model.Fund;
import jhonatan.sabadi.desafioo.service.FundDataSourceFactory;
import jhonatan.sabadi.desafioo.ui.adapter.FundAdapter;
import jhonatan.sabadi.desafioo.ui.viewmodel.FundViewModel;
import jhonatan.sabadi.desafioo.ui.viewmodelfactory.FundViewModelFactory;

public class FundActivity extends AppCompatActivity implements OnRecyclerClickListener {

    private FundViewModel fundViewModel;
    private FundAdapter fundAdapter;
    private RecyclerView fundRecyclerView;
    private FundViewModelFactory fundViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund);

        loadViewModel();
        loadFunds();

    }

    private void loadViewModel() {
        fundViewModelFactory = new FundViewModelFactory(getApplication());
        fundViewModel = ViewModelProviders.of(this, fundViewModelFactory).get(FundViewModel.class);
    }

    private void initRecyclerView() {
        fundRecyclerView = findViewById(R.id.fundRecyclerView);
        fundRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fundRecyclerView.setHasFixedSize(true);
//        fundAdapter = new FundAdapter(funds, this);
//        fundRecyclerView.setAdapter(fundAdapter);
    }

    private void loadFunds() {
        LifecycleOwner lifecycleOwner = this;
        fundViewModel.getFunds().observe(lifecycleOwner, funds -> {
            if (funds != null) {
                initRecyclerView();
                PagedList.Config config = new PagedList.Config.Builder()
                        .setPageSize(20)
                        .build();
                FundDataSourceFactory fundDataSourceFactory = new FundDataSourceFactory(funds);
                LiveData fundLiveData = new LivePagedListBuilder(fundDataSourceFactory, config).build();
                fundLiveData.observe(lifecycleOwner, fundsPaged -> {
                    fundAdapter = new FundAdapter(this);
                    fundAdapter.submitList((PagedList<Fund>) fundsPaged);

                });
            }
        });
    }

    @Override
    public void setOnRecyclerClick(View view, int position) {
        Fund fund = fundAdapter.getFundAtPosition(position);
        Intent intent = new Intent(this, DetailsFundActivity.class);
        intent.putExtra("fund", (Parcelable) fund);
        startActivity(intent);
    }
}