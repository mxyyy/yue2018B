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
import com.example.yue2018b.util.JiaJian;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class YouAdapter extends RecyclerView.Adapter<YouAdapter.ViewHolder>{
private Context context;
private List<SecondBean.DataBean.SpusBean> data;
    public YouAdapter(Context context, List<SecondBean.DataBean.SpusBean> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.youitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.miaoshu.setText(data.get(position).getName());
        holder.sale.setText(data.get(position).getMonth_saled() + "");
        holder.price.setText("￥" + data.get(position).getPraise_num());
        holder.simple_img02.setImageURI(data.get(position).getPic_url());
        final SecondBean.DataBean.SpusBean listBean = data.get(position);

        holder.jiajiannn.setOnAddDecreaseListener(new JiaJian.OnAddDecreaseListener() {
            @Override
            public void add(int num) {
                listBean.setPraise_num(num);
                if(productListener!=null){
                    productListener.onChange(position,num);
                }
            }

            @Override
            public void decrease(int num) {
                listBean.setPraise_num(num);
                if(productListener!=null){
                    productListener.onChange(position,num);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView miaoshu,sale,price;
        private final SimpleDraweeView simple_img02;
        private final JiaJian jiajiannn;

        public ViewHolder(View itemView) {
            super(itemView);
            miaoshu = itemView.findViewById(R.id.miaoshu);
            sale = itemView.findViewById(R.id.sale);
            price = itemView.findViewById(R.id.price);
            simple_img02 = itemView.findViewById(R.id.simple_img02);
            jiajiannn = itemView.findViewById(R.id.jiajiann);
        }
    }

    public interface OnProductClickListener{
        void OnProductClickListener(int postion, boolean ischecked);
    }
    private OnProductClickListener productClickListener;

    public void setOnProductClickListener(OnProductClickListener listener){
        this.productClickListener=listener;
    }
    public interface OnAddDecreaseProductListener{
        void onChange(int postion, int num);
    }
    private OnAddDecreaseProductListener productListener;
    public void setOnAddDecreaseProductListener(OnAddDecreaseProductListener listener){
        this.productListener=listener;
    }

}
