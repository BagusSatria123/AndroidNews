package com.bagus.androidnews.fragmentku;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bagus.androidnews.CategoryDetail;
import com.bagus.androidnews.R;

public class FragmentCategory extends Fragment {

    View view;
    TextView business,entertainment,health,science,sports,technology;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_category, container,false);

        business = view.findViewById(R.id.business);
        entertainment = view.findViewById(R.id.entertainment);
        health = view.findViewById(R.id.health);
        science = view.findViewById(R.id.science);
        sports = view.findViewById(R.id.sports);
        technology = view.findViewById(R.id.technology);

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("business","business");
                startActivity(intent);
            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("entertainment","entertainment");
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("health","health");
                startActivity(intent);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("science","science");
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("sports","sports");
                startActivity(intent);
            }
        });

        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CategoryDetail.class);
                intent.putExtra("technology","technology");
                startActivity(intent);
            }
        });

        return view;
    }
}
