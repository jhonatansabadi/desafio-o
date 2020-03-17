package jhonatan.sabadi.desafioo.controller;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.room.Room;

import jhonatan.sabadi.desafioo.model.Fund;
import jhonatan.sabadi.desafioo.service.FundDataSourceFactory;
import jhonatan.sabadi.desafioo.service.retrofit.RetrofitService;
import jhonatan.sabadi.desafioo.service.FundService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FundController {

    private Context context;
    private FundService retrofitService;
//    private RoomDB roomDB;

    public FundController(Context context) {
        this.context = context;
        this.retrofitService = RetrofitService.createService(context, FundService.class);
//        roomDB = Room.databaseBuilder(
//                context,
//                RoomDB.class,
//                "fund"
//        ).build();
    }

    public void insertFundsOnDb() {

    }

    private Callback<JSONArray> fundResponse = new Callback<JSONArray>() {
        @Override
        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
            if (response.body() != null) {

            }
        }

        @Override
        public void onFailure(Call<JSONArray> call, Throwable t) {
            t.printStackTrace();
        }
    };

    public LiveData<List<Fund>> getFunds() {
        final MutableLiveData mutableLiveData = new MutableLiveData<List<Fund>>();
        Call<List<Fund>> funds = retrofitService.getFunds("fund_detail_full");
        funds.enqueue(new Callback<List<Fund>>() {
            @Override
            public void onResponse(Call<List<Fund>> call, Response<List<Fund>> response) {
                if (response.body() != null) {
//                    mutableLiveData.setValue(fundLiveData);
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
