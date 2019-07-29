package com.example.labtrentruong.Lab2_3.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.labtrentruong.ItemClickListener;
import com.example.labtrentruong.Models.DongVat;
import com.example.labtrentruong.R;

import java.util.List;
import java.util.Random;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.ViewHolder> {
    Context mContext;
    List<DongVat>_list;
    private Random mRandom = new Random();

    public recycleAdapter(Context mContext, List<DongVat> _list) {
        this.mContext = mContext;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycleview, viewGroup, false);
        return new recycleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgHinhAnh_rcv.setImageResource(_list.get(i).getHinhAnh());
        viewHolder.imgHinhAnh_rcv.getLayoutParams().height = getRandomIntInRange(400,250);
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(mContext, "Bạn vừa chọn vào con "+_list.get(pos).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected int getRandomIntInRange(int max, int min){
        return mRandom.nextInt((max-min)+min)+min;
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgHinhAnh_rcv;
        private ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhAnh_rcv= (ImageView)itemView.findViewById(R.id.imgHinhAnh_rcv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }
}
