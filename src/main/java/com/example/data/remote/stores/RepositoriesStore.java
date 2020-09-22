package com.example.data.remote.stores;

import com.example.data.models.repository.Repository;
import com.example.data.remote.ClientAPI;
import com.example.data.remote.Credentials;
import io.reactivex.Observable;

import java.util.List;

public class RepositoriesStore {
    private final Credentials credentials = Credentials.getInstance();
    public Observable<List<Repository>> getRepositories(String userLogin) {
        return ClientAPI.getClientAPI()
                .getRepositories(
                        userLogin
                );
    }

    public Observable<List<Repository>> getSubscriptions(String userLogin) {
       return ClientAPI.getClientAPI().getSubscriptions(
                userLogin
        );
    }

}
