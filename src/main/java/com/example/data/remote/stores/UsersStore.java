package com.example.data.remote.stores;

import com.example.data.models.User;
import com.example.data.remote.ClientAPI;
import com.example.data.remote.Credentials;
import io.reactivex.Observable;

import java.util.List;


public class UsersStore {
    public Observable<List<User>> getUsers() {
       return ClientAPI.getClientAPI().getUsers();
    }
}
