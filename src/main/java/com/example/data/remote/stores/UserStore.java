package com.example.data.remote.stores;


import com.example.data.models.User;
import com.example.data.remote.ClientAPI;
import com.example.data.remote.Credentials;
import io.reactivex.Observable;

import java.util.List;

public class UserStore {
    public Observable<User> loadUser(String userLogin) {
        return ClientAPI.getClientAPI().getUser(
                userLogin
        );
    }

    public Observable<List<User>> getFollowers(String userLogin){
        return ClientAPI.getClientAPI()
                .getFollowers(userLogin);
    }

    public Observable<List<User>> getFollowing(String userLogin) {
        return ClientAPI.getClientAPI().getFollowing(userLogin);
    }

}
