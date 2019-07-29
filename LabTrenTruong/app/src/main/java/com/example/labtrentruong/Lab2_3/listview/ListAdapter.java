package com.example.labtrentruong.Lab2_3.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.labtrentruong.Models.DongVat;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<DongVat> dongVats;

    public ListAdapter(Context mContext, ArrayList<DongVat> dongVats) {
        this.mContext = mContext;
        this.dongVats = dongVats;
    }

    @Override
    public int getCount() {
        return dongVats.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class   ViewHolder{
        TextView txtname;
        ImageView imgHinhAnh;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final DongVat dv = dongVats.get(position);
        ListAdapter.ViewHolder viewHolder;
        if(convertView==null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_list, null);
            viewHolder = new ListAdapter.ViewHolder();
            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txtName_List);
            viewHolder.imgHinhAnh = (ImageView) convertView.findViewById(R.id.imgHinhAnh_list);
            convertView.setTag(viewHolder);
        } else {
            viewHolder= (ListAdapter.ViewHolder)convertView.getTag();
        }
        viewHolder.txtname.setText(dv.getName());
        viewHolder.imgHinhAnh.setImageResource(dv.getHinhAnh());
        return convertView;
    }
}
