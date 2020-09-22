package com.example.data.remote.stores.file;

import com.example.data.remote.ClientAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class FileClient {
    private static final String FILE_BASE_URL = "https://raw.githubusercontent.com/";
    private static final Retrofit client = new Retrofit.Builder()
            .baseUrl(FILE_BASE_URL)
            .client(ClientAPI.getHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    static FileAPI getAPI() {
        return client.create(FileAPI.class);
    }
}
