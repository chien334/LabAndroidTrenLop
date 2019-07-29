package com.example.labtrentruong.Lab2_3.recycleview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.labtrentruong.Models.DongVat;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class recycle_fragment extends Fragment {
    View v;
    recycleAdapter adapter;
    ArrayList<DongVat> _list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.recycleview,container,false);
        RecyclerView recyclerView = v.findViewById(R.id.recycle_fragment);
        _list= DongVat.init();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        adapter = new recycleAdapter(getContext(),_list);
        recyclerView.setAdapter(adapter);
        return v;
    }
}
