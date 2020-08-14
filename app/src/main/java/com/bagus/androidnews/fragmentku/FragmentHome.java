package com.bagus.androidnews.fragmentku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.androidnews.adapter.MyAdapter;
import com.bagus.androidnews.retrofitconfig.GetJsonAll;
import com.bagus.androidnews.retrofitjson.News;

import java.util.List;

public class FragmentHome extends Fragment {

    List<News> newsList;
    GetJsonAll getJsonAll;
    String title,description;

    RecyclerView recycler_view;
    MyAdapter myAdapter;
    GridLayoutManager gm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
