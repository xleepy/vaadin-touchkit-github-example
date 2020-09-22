package com.example.data.models.branch;

import com.example.data.models.commit.Commit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Branch {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("commit")
    @Expose
    private Commit commit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}
