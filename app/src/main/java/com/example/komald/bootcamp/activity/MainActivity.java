package com.example.komald.bootcamp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.komald.bootcamp.model.Customer;
import com.example.komald.bootcamp.api.CustomerApi;
import com.example.komald.bootcamp.R;
import com.example.komald.bootcamp.adapter.CustomerDetailAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    RecyclerView customerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAllViews();
    }
    final CustomerDetailAdapter customerDetailAdapter = new CustomerDetailAdapter(MainActivity.this,new ArrayList<Customer>());
    void setAllViews()
    {
        customerlist = (RecyclerView)findViewById(R.id.recycler_view);
        customerlist.setLayoutManager(new LinearLayoutManager(this));
        customerlist.setAdapter(customerDetailAdapter);
        CustomerApi response = new CustomerApi(this);
        CustomerApi.getCustomers(new CustomerApi.CustomerDetail(){
            @Override
            public void setCustomers(List<Customer> customers) {
                customerDetailAdapter.addCustomers(customers);
            }
        });
    }
}
