package com.example.data.models.commit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitDetailed {
    @SerializedName("author")
    @Expose
    private Author author;

    @SerializedName("commiter")
    @Expose
    private Author commiter;

    @SerializedName("message")
    @Expose
    private String message;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getCommiter() {
        return commiter;
    }

    public void setCommiter(Author commiter) {
        this.commiter = commiter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
