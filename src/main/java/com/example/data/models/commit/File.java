package com.example.data.models.commit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File {
    @SerializedName("filename")
    @Expose
    private String filename;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("additions")
    @Expose
    private Number additions;

    @SerializedName("deletions")
    @Expose
    private Number deletions;

    @SerializedName("raw_url")
    @Expose
    private String rawUrl;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Number getAdditions() {
        return additions;
    }

    public void setAdditions(Number additions) {
        this.additions = additions;
    }

    public Number getDeletions() {
        return deletions;
    }

    public void setDeletions(Number deletions) {
        this.deletions = deletions;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }
}
