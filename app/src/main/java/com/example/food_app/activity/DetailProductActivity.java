package com.example.food_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food_app.R;
import com.example.food_app.model.ProductModel;

public class DetailProductActivity extends AppCompatActivity {
    private TextView btnAddCart;
    private TextView txtName, txtFee, txtDes, txtQuantityOrder;
    private ImageView btnPlus, btnMinus, imgPic;

    private ProductModel productModel;

    int quantityOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        mapping();
        getBundle();
    }

    private void getBundle() {
        productModel = (ProductModel) getIntent().getSerializableExtra("productModel");

        int drawableResourceId = this.getResources().getIdentifier(productModel.getPic(), "drawable", this.getPackageName());
        Log.d("drawableResourceId",String.valueOf(drawableResourceId));
        Glide.with(this)
                .load(drawableResourceId)
                .into(imgPic);

        txtName.setText(productModel.getName());
        txtFee.setText("$" + productModel.getFee());
        txtDes.setText(productModel.getDes());
        txtQuantityOrder.setText(String.valueOf(quantityOrder));

//        checkVisibleBtn();
        handlePlus();
        handleMinus();
    }

    private void handlePlus() {

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityOrder = quantityOrder + 1;
                txtQuantityOrder.setText(String.valueOf(quantityOrder));
            }
        });
    }

    private void handleMinus() {
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityOrder > 1) {
                    quantityOrder = quantityOrder - 1;
                    txtQuantityOrder.setText(String.valueOf(quantityOrder));
                } else {
                    txtQuantityOrder.setText(String.valueOf(quantityOrder));
                }
            }
        });
    }

    private void checkVisibleBtn() {
        if (quantityOrder > 1) {
            btnMinus.setEnabled(true);
            btnMinus.setColorFilter(this.getResources().getColor(R.color.orange_ff5e00));
        } else {
            btnMinus.setEnabled(false);
            btnMinus.setColorFilter(this.getResources().getColor(R.color.gray_ececec));
        }
    }

    private void mapping() {
        btnAddCart = findViewById(R.id.detailP_addTo_cart);
        txtName = findViewById(R.id.detailP_name);
        txtFee = findViewById(R.id.detailP_fee);
        txtDes = findViewById(R.id.detailP_des);
        txtQuantityOrder = findViewById(R.id.detailP_quantity);
        btnPlus = findViewById(R.id.detailP_plus);
        btnMinus = findViewById(R.id.detailP_minus);
        imgPic = findViewById(R.id.detailP_pic);
    }
}