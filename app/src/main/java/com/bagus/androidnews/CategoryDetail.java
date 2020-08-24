package com.bagus.androidnews;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryDetail extends AppCompatActivity {

    TextView category_detail;
    String business;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_detail);
        category_detail=findViewById(R.id.category_detail);

        business=getIntent().getStringExtra("business");
        category_detail.setText(business);
    }
}
