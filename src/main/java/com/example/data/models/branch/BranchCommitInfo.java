package com.example.data.models.branch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BranchCommitInfo {
    @SerializedName("sha")
    @Expose
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
