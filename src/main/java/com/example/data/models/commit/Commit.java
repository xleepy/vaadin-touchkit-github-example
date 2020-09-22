package com.example.data.models.commit;

import com.example.data.models.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Commit {

    @SerializedName("sha")
    @Expose
    private String sha;

    @SerializedName("commit")
    @Expose
    private CommitDetailed commitDetailed;

    @SerializedName("author")
    @Expose
    private User author;

    @SerializedName("commiter")
    @Expose
    private User commiter;

    @SerializedName("files")
    @Expose
    private List<File> files;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public CommitDetailed getCommitDetailed() {
        return commitDetailed;
    }

    public void setCommitDetailed(CommitDetailed commitDetailed) {
        this.commitDetailed = commitDetailed;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getCommiter() {
        return commiter;
    }

    public void setCommiter(User commiter) {
        this.commiter = commiter;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
