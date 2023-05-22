package com.example.food_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.food_app.R;
import com.example.food_app.adaptor.CategoryAdaptor;
import com.example.food_app.adaptor.ProductAdaptor;
import com.example.food_app.model.CategoryModel;
import com.example.food_app.model.ProductModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterCategory, adapterProduct;
    private RecyclerView recyclerCategories, recyclerProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        recyclerViewCategoryList();
        recycleViewPopular();
    }

    private void mapping() {
        recyclerCategories = findViewById(R.id.home_recycle_categories);
        recyclerProducts = findViewById(R.id.home_recycle_products);
    }

    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerCategories.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("Pizza", "cat_1"));
        categories.add(new CategoryModel("Burger", "cat_2"));
        categories.add(new CategoryModel("Hotdog", "cat_3"));
        categories.add(new CategoryModel("Drink", "cat_4"));
        categories.add(new CategoryModel("Donut", "cat_5"));

        adapterCategory = new CategoryAdaptor(categories);
        recyclerCategories.setAdapter(adapterCategory);
    }

    private void recycleViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerProducts.setLayoutManager(linearLayoutManager);

        ArrayList<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel("Pepperoni pizza","pop_1", "slices pepperoni, mozzarella cheese, fresh oregano", 9.76));
        products.add(new ProductModel("Cheese Burger","pop_2", "slices pepperoni, mozzarella cheese, fresh oregano", 9.76));
        products.add(new ProductModel("Vegetable pizza","pop_3", "slices pepperoni, mozzarella cheese, fresh oregano", 9.76));

        adapterProduct = new ProductAdaptor(products);
        recyclerProducts.setAdapter(adapterProduct);
    }
}