package com.example.data.remote;

import com.example.data.models.Email;
import com.example.data.models.User;
import com.example.data.models.repository.File;
import com.example.data.models.repository.Repository;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;

public interface JsonAPI {

    @GET("user")
    Observable<User>getAuthenticatedUser(
            @Header("Authorization") String AuthToken
    );

    @GET("user/emails")
    List<Email>getUserEmail(
            @Header("Authorization") String AuthToken
    );

    @PATCH("user")
    Observable<User> updateAuthenticatedUser(
            @Header("Authorization") String AuthToken,
            @Body String data
    );

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users/{login}/followers")
    Observable<List<User>> getFollowers(@Path("login") String login);

    @GET("users/{login}/following")
    Observable<List<User>> getFollowing(@Path("login") String login);

    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String login);

    @GET("users/{user}/repos")
    Observable<List<Repository>> getRepositories(
            @Path("user") String user
    );

    @GET("users/{user}/subscriptions")
    Observable<List<Repository>> getSubscriptions(
            @Path("user") String user
    );

    @GET("repos/{user}/{repoName}/contents/")
    Observable<List<File>> getRepositoryFiles(
            @Path("user") String user,
            @Path("repoName") String repoName
    );

    @GET("repos/{user}/{repoName}/contents/{pathName}")
    Observable<List<File>> getDirectory(
            @Path("user") String login,
            @Path("repoName") String repoName,
            @Path("pathName") String pathName
    );

}
