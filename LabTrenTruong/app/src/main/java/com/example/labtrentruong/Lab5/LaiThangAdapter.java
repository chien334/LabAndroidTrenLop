package com.example.labtrentruong.Lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.labtrentruong.Models.LaiThangKH;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class LaiThangAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<LaiThangKH> _list;

    public LaiThangAdapter(Context mContext, ArrayList<LaiThangKH> _list) {
        this.mContext = mContext;
        this._list = _list;
    }

    @Override
    public int getCount() {
        return _list.size();
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
        LaiThangKH dv = _list.get(position);
        LaiThangAdapter.ViewHolder viewHolder;
        if(convertView==null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_lai_thang, null);
            viewHolder = new LaiThangAdapter.ViewHolder();
            viewHolder.txtNamekh = (TextView) convertView.findViewById(R.id.txtKhachHang);
            viewHolder.txtSotienTra = (TextView) convertView.findViewById(R.id.txtSoTienThang);
            viewHolder.txtSoThang = (TextView) convertView.findViewById(R.id.txtSoThangTra);
            convertView.setTag(viewHolder);
        } else {
            viewHolder= (LaiThangAdapter.ViewHolder)convertView.getTag();
        }
        int tienTraThang= (dv.getSoTienVay()/dv.getSoThangTra())*dv.getLaiXuat();
        viewHolder.txtNamekh.setText( "Họ tên KH : " + dv.getNameKH());
        viewHolder.txtSotienTra.setText("Số tiền/Tháng: " + tienTraThang);
        viewHolder.txtSoThang.setText("Số Tháng Trả: " + dv.getSoThangTra());

        return convertView;
    }
    private class   ViewHolder{
        TextView txtNamekh,txtSotienTra,txtSoThang;
    }
}
