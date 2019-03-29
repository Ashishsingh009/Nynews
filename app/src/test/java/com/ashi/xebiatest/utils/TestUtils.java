package com.ashi.xebiatest.utils;

import com.ashi.xebiatest.models.NyResponse;
import com.ashi.xebiatest.view.NyNewsActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestUtils {
    // private static Gson mGson;
    private static TestUtils INSTANCE = new TestUtils();

    public static <T> T loadJson(String path, Gson mGson) {
        mGson = new Gson();
        String json = getFileString(path);
        //noinspection unchecked
        return (T) mGson.fromJson(json, NyResponse.class);
    }

    public static <T> T loadggnJson(String path, Gson mGson) {
        mGson = new Gson();
        String json = getFileString(path);
        //noinspection unchecked
        return (T) mGson.fromJson(json, NyNewsActivity.class);
    }

    private static String getFileString(String path) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    INSTANCE.getClass().getClassLoader().getResourceAsStream(path)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not read from resource at: " + path);
        }
    }
}
