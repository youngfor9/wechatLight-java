package com.yang.Utils;

import com.google.gson.Gson;

public class JsonUtils {
    public static String toJsonString(Object args) {
        Gson gson = new Gson();
        return gson.toJson(args);
    }
    public static Object toObject(String json,Class beanClass) {
        Gson gson = new Gson();
        Object res = gson.fromJson(json, beanClass);
        return res;
    }
}
