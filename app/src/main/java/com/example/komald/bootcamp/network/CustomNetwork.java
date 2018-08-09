package com.example.komald.bootcamp.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CustomNetwork {

    private static CustomNetwork mInstance;
    private ImageLoader imageLoader;
    private Context context;

    public interface NetworkResponse {
        void onSuccess(String response);
    }

    private CustomNetwork(Context context) {
        this.context = context;
        this.imageLoader = new ImageLoader(getRequestQueue(), new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap>
                    cache = new LruCache<>(20);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public void makeRequest(int methodType, String url,final NetworkResponse getNetworkresponse) {
        StringRequest request = new StringRequest(methodType, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("CODE RESPONSE", response);
                getNetworkresponse.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "QlRXSU5ZV1I0VnZPWTlqNUJFY0I=");
                return params;
            }
        };
        RequestQueue requestQueue = getRequestQueue();
        requestQueue.add(request);
    }

    //Singleton class.....
    public static synchronized CustomNetwork getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CustomNetwork(context);
        }
        return mInstance;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public RequestQueue getRequestQueue() {
        return Volley.newRequestQueue(context);
    }
}

