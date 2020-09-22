package com.example.data.remote.stores.file;

import com.example.data.remote.Credentials;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileStore {

    public Observable<ResponseBody> loadFile(String userName, String repoName, String path) {
        return FileClient.getAPI().getFileForPreview(
                userName,
                repoName,
                path
        );
    }

    public String readFile(ResponseBody body) {
        try {
            StringBuilder sb = new StringBuilder();
            InputStreamReader streamReader = new InputStreamReader(body.byteStream());
            BufferedReader br = new BufferedReader(streamReader);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            streamReader.close();
            br.close();
            return sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
