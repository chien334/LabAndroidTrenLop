package com.example.labtrentruong.Lab2_3.listview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.labtrentruong.Models.DongVat;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class list_fragment extends Fragment {
    View v;
    ListView listView;
    ArrayList<DongVat> _list;
    ListAdapter item;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.listview,container,false);
        listView= (ListView) v.findViewById(R.id.list_fragment);
        _list=DongVat.init();
        item= new ListAdapter(getContext(),_list);
        listView.setAdapter(item);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Bạn vừa click vào hình con "+ _list.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
       return v;
    }
}
