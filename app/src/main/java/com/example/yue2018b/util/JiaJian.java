package com.example.yue2018b.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.yue2018b.R;

import butterknife.OnClick;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class JiaJian extends RelativeLayout implements View.OnClickListener {
    private int num=0;
    private ImageView txtadd;
    private ImageView txtdecrease;
    private TextView txtnum;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        txtnum.setText(num+"");
    }
    public interface OnAddDecreaseListener{
        void add(int num);
        void decrease(int num);
    }
    private OnAddDecreaseListener listener;
    public void setOnAddDecreaseListener(OnAddDecreaseListener listener){
        this.listener=listener;
    }
    public JiaJian(Context context) {
        this(context,null);
    }

    public JiaJian(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public JiaJian(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.jiajian,this);
        txtadd = findViewById(R.id.jia);
        txtdecrease = findViewById(R.id.jian);
        txtnum = findViewById(R.id.num);
        txtnum.setText("0");
        txtadd.setOnClickListener(this);
        txtdecrease.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jia:
                txtdecrease.setVisibility(VISIBLE);
                num++;
                txtnum.setText(num+"");
                if(listener!=null){
                    listener.add(num);
                }
                break;
            case R.id.jian:

                if(num>0) {
                    num--;
                }
                else if (num<1){
                    txtdecrease.setVisibility(GONE);
                }
                txtnum.setText(num+"");
                if(listener!=null){
                    listener.decrease(num);
                }
                break;
        }
    }
}