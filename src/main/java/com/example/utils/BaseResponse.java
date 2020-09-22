package com.example.utils;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("msg")
    public String msg;

    @SerializedName("status")
    public int status;
}
