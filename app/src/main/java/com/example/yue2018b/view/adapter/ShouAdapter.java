package com.example.yue2018b.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yue2018b.R;
import com.example.yue2018b.model.bean.ShouBean;
import com.example.yue2018b.view.activity.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class ShouAdapter extends RecyclerView.Adapter<ShouAdapter.ViewHolder>{
private Context context;
private List<ShouBean.DataBean> data;
    public ShouAdapter(Context context, List<ShouBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // Uri uri = Uri.parse(data.get(position).getPic_url().split("\\|")[0]);
        holder.simple_img.setImageURI(data.get(position).getPic_url());
        holder.dianming.setText(data.get(position).getName());
        holder.qisong.setText(data.get(position).getMin_price_tip());
        holder.shijian.setText(data.get(position).getDelivery_time_tip());
        holder.xiaoliang.setText(data.get(position).getMonth_sales_tip());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,XiangActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView dianming,shijian,qisong,xiaoliang,manjian;
        private final SimpleDraweeView simple_img;

        public ViewHolder(View itemView) {
            super(itemView);
            dianming = itemView.findViewById(R.id.dianming);
            shijian = itemView.findViewById(R.id.shijian);
            qisong = itemView.findViewById(R.id.qisong);
            xiaoliang = itemView.findViewById(R.id.xiaoliang);
            manjian = itemView.findViewById(R.id.manjian);
            simple_img = itemView.findViewById(R.id.simple_img);
        }
    }
}
