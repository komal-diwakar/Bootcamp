package com.example.komald.bootcamp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.komald.bootcamp.model.Customer;
import com.example.komald.bootcamp.R;

public class CustomerDetailActivity extends AppCompatActivity {

    TextView name,des,email,company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        company = (TextView)findViewById(R.id.company);
        des = (TextView)findViewById(R.id.designation);
        Intent intent = getIntent();
        Customer customer = intent.getParcelableExtra("customers detail");
        name.setText("Name : "+customer.getName());
        des.setText("Designation : "+customer.getJobTitle());
        email.setText("Email Id : "+customer.getEmail());
        company.setText("Company : "+customer.getCompanyId());

    }
}
