package com.yang.Utils;

import com.google.gson.Gson;

public class JsonUtils {
    public static String toJsonString(Object args) {
        Gson gson = new Gson();
        return gson.toJson(args);
    }
}
