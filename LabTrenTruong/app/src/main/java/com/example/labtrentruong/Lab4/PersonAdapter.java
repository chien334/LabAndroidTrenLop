package com.example.labtrentruong.Lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.labtrentruong.Models.Person;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    ArrayList<Person> listData;
    LayoutInflater inflater;
    ImageView imgAvatar;
    TextView txtName, txtAddress, txtPhone;
    public PersonAdapter(ArrayList<Person> listData, Context context) {
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    public ArrayList<Person> getListData() {
        return listData;
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Person getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_listview, null);

        imgAvatar = (ImageView) convertView.findViewById(R.id.imgAvatar);
        txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtAddress = (TextView) convertView.findViewById(R.id.txtAddress);
        txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);

        Person ps = (Person) getItem(position);
        imgAvatar.setImageResource(ps.getAvatar());
        txtName.setText(ps.getName().toString());
        txtAddress.setText(ps.getAddress().toString());
        txtPhone.setText(ps.getPhone().toString());
        return convertView;
    }
}
