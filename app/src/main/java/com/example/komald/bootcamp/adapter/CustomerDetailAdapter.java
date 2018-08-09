package com.example.komald.bootcamp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.komald.bootcamp.activity.CustomerDetailActivity;
import com.example.komald.bootcamp.model.Customer;
import com.example.komald.bootcamp.network.CustomNetwork;
import com.example.komald.bootcamp.R;

import java.util.List;

public class CustomerDetailAdapter extends RecyclerView.Adapter<CustomerDetailAdapter.RecyclerViewHolder> {

    Context context;
    List<Customer> customers;

    public interface OnItemClickListener {
        void onItemClick(Customer item);
    }

    public CustomerDetailAdapter(Context ctx, List<Customer> customers)
    {
        context = ctx;
        this.customers = customers;
    }

    public void addCustomers(List<Customer> customers) {
        this.customers.addAll(customers);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View myView = layoutInflater.inflate(R.layout.recycle_view_layout,viewGroup,false);
        return new RecyclerViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerDetailAdapter.RecyclerViewHolder recyclerViewHolder, int position) {
        Customer customer = customers.get(position);
        recyclerViewHolder.name.setText(customer.getName());
        recyclerViewHolder.customerDes.setText(customer.getJobTitle());
        recyclerViewHolder.customerImage.setImageUrl("https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png", CustomNetwork.getInstance(context).getImageLoader());
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name, customerDes;
        NetworkImageView customerImage;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView)itemView.findViewById(R.id.customer_name);
            customerDes = (TextView)itemView.findViewById(R.id.customer_des);
            customerImage = (NetworkImageView)itemView.findViewById(R.id.customer_img);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context,CustomerDetailActivity.class);
            intent.putExtra("customers detail",customers.get(position));
            context.startActivity(intent);
        }
    }
}
