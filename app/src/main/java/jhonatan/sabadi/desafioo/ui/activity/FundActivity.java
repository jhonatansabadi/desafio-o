package jhonatan.sabadi.desafioo.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.interfaces.OnRecyclerClickListener;
import jhonatan.sabadi.desafioo.model.Fund;
import jhonatan.sabadi.desafioo.service.datasource.FundLiveDataPaged;
import jhonatan.sabadi.desafioo.ui.adapter.FundAdapter;
import jhonatan.sabadi.desafioo.ui.viewmodel.FundViewModel;
import jhonatan.sabadi.desafioo.ui.viewmodelfactory.FundViewModelFactory;

public class FundActivity extends AppCompatActivity implements OnRecyclerClickListener {

    private FundViewModel fundViewModel;
    private FundAdapter fundAdapter;
    private RecyclerView fundRecyclerView;
    private FundViewModelFactory fundViewModelFactory;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund);
        initProgressBar();
        loadViewModel();
        loadFunds();
    }


    private void initProgressBar() {
        progressBar = findViewById(R.id.progressBarFund);
        showProgressBar();
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void loadViewModel() {
        fundViewModelFactory = new FundViewModelFactory(getApplication());
        fundViewModel = ViewModelProviders.of(this, fundViewModelFactory).get(FundViewModel.class);
    }

    private void initRecyclerView() {
        fundRecyclerView = findViewById(R.id.fundRecyclerView);
        fundRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fundRecyclerView.setHasFixedSize(true);
    }

    private void loadFunds() {
        LifecycleOwner lifecycleOwner = this;
        fundViewModel.getFunds().observe(lifecycleOwner, fundsObserver);
    }

    private Observer fundsObserver = new Observer<List<Fund>>() {
        @Override
        public void onChanged(List<Fund> funds) {
            if (funds != null) {
                initRecyclerView();
                LiveData<PagedList<Fund>> fundLiveData = FundLiveDataPaged.getInstanceLiveData(funds);
                fundLiveData.observe(FundActivity.this, pagedListObserver);
            }
        }
    };


    private Observer pagedListObserver = new Observer<PagedList<Fund>>() {
        @Override
        public void onChanged(PagedList<Fund> fundsPaged) {
            fundAdapter = new FundAdapter(FundActivity.this);
            fundAdapter.submitList(fundsPaged);
            fundRecyclerView.setAdapter(fundAdapter);
            hideProgressBar();
        }
    };

    @Override
    public void setOnRecyclerClick(View view, int position) {
        Fund fund = fundAdapter.getFundAtPosition(position);
        Intent intent = new Intent(this, DetailsFundActivity.class);
        intent.putExtra("fund", fund);
        startActivity(intent);
    }

}