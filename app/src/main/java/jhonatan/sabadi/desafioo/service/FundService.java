package jhonatan.sabadi.desafioo.service;

import org.json.JSONArray;

import java.util.List;

import androidx.paging.PagedList;
import jhonatan.sabadi.desafioo.model.Fund;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FundService {

    @GET("/orama-media/json/fund_detail_full.json")
    Call<List<Fund>> getFunds(@Query("serializ er") String source);

    @GET("/orama-media/json/fund_detail_full.json")
    Call getFundsJson(@Query("serializ er") String source);

}
