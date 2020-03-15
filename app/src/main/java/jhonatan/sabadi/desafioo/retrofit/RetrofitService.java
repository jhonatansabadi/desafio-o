package jhonatan.sabadi.desafioo.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jhonatan.sabadi.desafioo.R;
import jhonatan.sabadi.desafioo.service.FundService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static <T> T createService(Context context, Class<T> serviceClass) {
        String baseUrl = context.getString(R.string.base_url);
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(serviceClass);
    }

}
