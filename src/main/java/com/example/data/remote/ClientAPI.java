package com.example.data.remote;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ClientAPI {
    private static final String BASE_URL = "https://api.github.com/";
    private static final String TOKEN_KEY = "TOKEN";

    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

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
        String token = dotenv.get(TOKEN_KEY) == null ? System.getenv(TOKEN_KEY) : dotenv.get(TOKEN_KEY);

        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("User-Agent", Credentials.USER_AGENT)
                    .addHeader("X-GitHub-Media-Type", Credentials.MEDIA_TYPE)
                    .addHeader("Authorization", "token " + token)
                    .build();
            return chain.proceed(request);
        });
        return httpClient.build();
    }
}
