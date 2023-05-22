package com.example.food_app.adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food_app.R;
import com.example.food_app.activity.DetailProductActivity;
import com.example.food_app.model.ProductModel;

import java.util.ArrayList;

public class ProductAdaptor extends RecyclerView.Adapter<ProductAdaptor.ViewHolder> {
    ArrayList<ProductModel> productModels;

    public ProductAdaptor(ArrayList<ProductModel> productModels) {
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(productModels.get(position).getName());
        holder.fee.setText(String.valueOf(productModels.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productModels.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailProductActivity.class);
                intent.putExtra("productModel", productModels.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productModels == null ? 0 : productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, fee;
        TextView addBtn;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            fee = itemView.findViewById(R.id.product_fee);
            addBtn = itemView.findViewById(R.id.product_addBtn);
            pic = itemView.findViewById(R.id.product_pic);
        }
    }
}
