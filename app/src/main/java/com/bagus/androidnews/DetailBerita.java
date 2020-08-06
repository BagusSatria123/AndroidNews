package com.bagus.androidnews;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailBerita extends AppCompatActivity {

    String title;
    TextView titles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_berita);

        titles =findViewById(R.id.titles);
        title = getIntent().getStringExtra("title");

        Log.d("Titleku",title);
        Toast.makeText(getApplicationContext(),"Anda telah klick "+title,Toast.LENGTH_LONG).show();
        titles.setText(title);


    }
}
