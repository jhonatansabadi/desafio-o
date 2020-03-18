package jhonatan.sabadi.desafioo.service.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jhonatan.sabadi.desafioo.R;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static <T> T createService(Context context, Class<T> serviceClass) {
        String baseUrl = context.getString(R.string.base_url);
        Gson gson = new GsonBuilder()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        long cacheSize = 5 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

}
