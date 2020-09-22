package com.example.data.remote.stores.file;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface FileAPI {
    // TODO: make for different branches
    @Streaming
    @GET("{userName}/{repository}/master/{filepath}")
    Observable<ResponseBody> getFileForPreview(
            @Path("userName") String login,
            @Path("repository") String repoName,
            @Path("filepath") String path
    );
}
