package com.example.labtrentruong.Lab2_3.gridview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.labtrentruong.Models.DongVat;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class grid_fragment extends Fragment {
    View v;
    GridView gridview;
    ArrayList<DongVat> _list;
    itemgridview item;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.gridview, container, false);
        gridview= (GridView)v.findViewById(R.id.grid_fragment);
        _list=DongVat.init();
        item= new itemgridview(getContext(),_list);
        gridview.setAdapter(item);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Bạn vừa chọn hình con "+_list.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
