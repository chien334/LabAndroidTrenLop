package com.example.labtrentruong.Lab2_3.gridview;

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

public class itemgridview extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<DongVat> dongVats;

    public itemgridview(Context context, ArrayList<DongVat> dongVats) {
        this.mContext = context;
        this.dongVats = dongVats;
    }

    private   class   ViewHolder{
        private  TextView txtname;
        private ImageView imgHinhAnh;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final DongVat dv = dongVats.get(position);
        ViewHolder viewHolder;
        if(convertView==null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_gridview, null);
            viewHolder = new ViewHolder();
            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.imgHinhAnh = (ImageView) convertView.findViewById(R.id.imgHinhAnh);
            convertView.setTag(viewHolder);
        } else {
            viewHolder= (ViewHolder)convertView.getTag();
        }
        viewHolder.txtname.setText(dv.getName());
        viewHolder.imgHinhAnh.setImageResource(dv.getHinhAnh());
        return convertView;
    }
}
