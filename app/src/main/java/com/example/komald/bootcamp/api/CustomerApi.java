package com.example.komald.bootcamp.api;

import android.content.Context;

import com.android.volley.Request;
import com.example.komald.bootcamp.model.Customer;
import com.example.komald.bootcamp.network.CustomNetwork;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class CustomerApi {

    private static final String url = "https://mobilebootcamp.freshdesk.com/" + "api/v2/contacts";
    private static Context context;
    public static List<Customer> customers;

    public interface CustomerDetail{
        void setCustomers(List<Customer> customers);
    }
    private CustomerDetail customerDetail;

    public CustomerApi(Context context) {
        this.context = context;
    }
    public static void getCustomers(final CustomerDetail listener){
        CustomNetwork.getInstance(context).makeRequest(Request.Method.GET, url, new CustomNetwork.NetworkResponse() {
            @Override
            public void onSuccess(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                customers = gson.fromJson(response, new TypeToken<List<Customer>>(){
                }.getType());
                listener.setCustomers(customers);
            }
        });
    }
}
