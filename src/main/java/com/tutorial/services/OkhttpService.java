package com.tutorial.services;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@EnableAutoConfiguration(exclude={ErrorMvcAutoConfiguration.class})
@Component
public class OkhttpService {

  public JSONObject postApiConFormBody(String url, RequestBody formBody) throws IOException {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()

        .url(url)

        .post(formBody)

        .build();

    Response response = client.newCall(request).execute();

    String result = response.body().string();

    JSONObject jsonObject = new JSONObject(result);

    return jsonObject;
  }

  public JSONObject postApi(String url) throws IOException {

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()

        .url(url)

        .build();

    Response response = client.newCall(request).execute();

    String result = response.body().string();

    JSONObject object = new JSONObject(result);

    return object;
  }

  public Integer postApiGuardar(String url) throws IOException {

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()

        .url(url)

        .build();

    Response response = client.newCall(request).execute();

    int result = response.code();

    return result;
  }
}
