package com.example.yue2018b.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yue2018b.R;
import com.example.yue2018b.model.bean.ShouBean;
import com.example.yue2018b.presenter.ShouPresenter;
import com.example.yue2018b.view.adapter.ShouAdapter;
import com.example.yue2018b.view.ivew.ShouView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ShouView {
    @BindView(R.id.rec_dian)
    RecyclerView recDian;
    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.text_loca)
    TextView textLoca;
    private ShouPresenter shouPresenter;
    private String sheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        shouPresenter = new ShouPresenter();
        shouPresenter.attach(this);
        shouPresenter.shouData();
        sheng = getIntent().getStringExtra("sheng");
        //EventBus传值
        //EventBus.getDefault().register(this);
        textLoca.setText(sheng);
    }

    @Override
    public void onSuccess(ShouBean shouBean) {
        List<ShouBean.DataBean> data = shouBean.getData();
        Log.e("aaa", data.get(0).getAddress());
        recDian.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ShouAdapter shouAdapter = new ShouAdapter(MainActivity.this, data);
        recDian.setAdapter(shouAdapter);
    }

    @Override
    public void onError(Throwable e) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        shouPresenter.datach();
    }
    @OnClick({R.id.location, R.id.text_loca})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.location:
                Intent intent=new Intent(MainActivity.this,LocaActivity.class);
                startActivity(intent);
                break;
            case R.id.text_loca:
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        textLoca.setText(sheng);
    }
}
