package jhonatan.sabadi.desafioo.controller;

import android.content.Context;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import jhonatan.sabadi.desafioo.model.Fund;
import jhonatan.sabadi.desafioo.service.FundService;
import jhonatan.sabadi.desafioo.service.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FundController {

    private FundService retrofitService;

    public FundController(Context context) {
        this.retrofitService = RetrofitService.createService(context, FundService.class);
    }

    public LiveData<List<Fund>> getFunds() {
        final MutableLiveData mutableLiveData = new MutableLiveData<List<Fund>>();
        Call<List<Fund>> funds = retrofitService.getFunds("fund_detail_full");
        funds.enqueue(new Callback<List<Fund>>() {
            @Override
            public void onResponse(Call<List<Fund>> call, Response<List<Fund>> response) {
                if (response.body() != null) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Fund>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return mutableLiveData;
    }
}
