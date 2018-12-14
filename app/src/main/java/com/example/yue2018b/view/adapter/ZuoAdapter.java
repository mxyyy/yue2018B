package com.example.yue2018b.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yue2018b.R;
import com.example.yue2018b.model.bean.SecondBean;

import java.util.List;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */


public class ZuoAdapter extends RecyclerView.Adapter<ZuoAdapter.ViewHolder> {
    private Context context;
    private List<SecondBean.DataBean> data;

    public ZuoAdapter(Context context, List<SecondBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item02, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
           holder.text_01.setText(data.get(position).getName());
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onItemClickListener.onItemClick(position);
               }
           });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView text_01;
        public ViewHolder(View itemView) {
            super(itemView);
            text_01 = itemView.findViewById(R.id.text_01);
        }
    }
    private  OnItemClickListener onItemClickListener;
    public interface  OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
