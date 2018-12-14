package com.example.yue2018b.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.yue2018b.R;
import com.example.yue2018b.model.bean.SecondBean;
import com.example.yue2018b.presenter.SecondPresenter;
import com.example.yue2018b.view.adapter.YouAdapter;
import com.example.yue2018b.view.adapter.ZuoAdapter;
import com.example.yue2018b.view.ivew.SecondView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangActivity extends AppCompatActivity implements SecondView {

    @BindView(R.id.rec_left)
    RecyclerView recLeft;
    @BindView(R.id.rec_right)
    RecyclerView recRight;
    private SecondPresenter secondPresenter;
    private List<SecondBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        ButterKnife.bind(this);
        secondPresenter = new SecondPresenter();
        secondPresenter.attach(this);
        secondPresenter.twoData();
        //recRight.setLayoutManager(new LinearLayoutManager(XiangActivity.this,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onSuccess(SecondBean secondBean) {
        data = secondBean.getData();
        recLeft.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ZuoAdapter zuoAdapter = new ZuoAdapter(XiangActivity.this,data);
        recLeft.setAdapter(zuoAdapter);

        zuoAdapter.setOnItemClickListener(new ZuoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(XiangActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
                recRight.setLayoutManager(new LinearLayoutManager(XiangActivity.this,LinearLayoutManager.VERTICAL,false));
                List<SecondBean.DataBean.SpusBean> spus = data.get(position).getSpus();
                YouAdapter youAdapter = new YouAdapter(XiangActivity.this,spus);
                recRight.setAdapter(youAdapter);

            }
        });
    }

    @Override
    public void onError(Throwable e) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        secondPresenter.datach();
    }
}
