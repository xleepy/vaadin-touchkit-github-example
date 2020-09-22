package com.example.data.models.repository;

import com.example.data.models.User;
import com.example.data.models.commit.File;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {
    @SerializedName("id")
    @Expose
    private Number id;

    @SerializedName("node_id")
    @Expose
    private String node_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("owner")
    @Expose
    private User user;

    @SerializedName("forks")
    @Expose
    private Number forksCount;


    @SerializedName("watchers")
    @Expose
    private Number watchersCount;

    @SerializedName("default_branch")
    @Expose
    private String defaultBranch;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Number getForksCount() {
        return forksCount;
    }

    public void setForksCount(Number forksCount) {
        this.forksCount = forksCount;
    }

    public Number getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(Number watchersCount) {
        this.watchersCount = watchersCount;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }
    @Override
    public String toString() {
        return "{ \n" +
                "user id: " + id +
                "\n name: " + name +
                "\n description: " + description +
                "\n user: " + user.toString() +
                "\n forks:" + forksCount +
                "\n watchers:" + watchersCount +
                "\n default branch:" + defaultBranch +
                "\n}";
    }
}
