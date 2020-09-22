package com.example.data.remote.stores;

import com.example.data.models.repository.File;
import com.example.data.remote.ClientAPI;
import com.example.data.remote.Credentials;
import io.reactivex.Observable;

import java.util.List;

public class RepositoryDetailStore {

    public Observable<List<File>> getRepoFiles(String userLogin, String repoName) {
        return ClientAPI.getClientAPI().getRepositoryFiles(
                userLogin,
                repoName
        );

    }

    public Observable<List<File>> getDirectoryFiles(String userLogin, String repoName, String dirName) {
        return ClientAPI.getClientAPI().getDirectory(
                userLogin,
                repoName,
                dirName
        );
    }


}
