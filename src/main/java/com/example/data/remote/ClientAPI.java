package com.example.data.remote;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


// TODO: rewrite authentication logic
public class ClientAPI {
    private static final String BASE_URL = "https://api.github.com/";

    private static final Retrofit client = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build();

    public static JsonAPI getClientAPI() {
        return client.create(JsonAPI.class);
    }

    public static OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("User-Agent", Credentials.USER_AGENT)
                    .addHeader("X-GitHub-Media-Type", Credentials.MEDIA_TYPE)
                    .addHeader("Authorization", "Bearer" +Credentials.getInstance().getToken())
                    .build();
            return chain.proceed(request);
        });
        return httpClient.build();
    }
}
