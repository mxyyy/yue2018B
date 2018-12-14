package com.example.yue2018b.model;

import com.example.yue2018b.model.bean.ShouBean;
import com.example.yue2018b.model.http.HttpUtils;

import io.reactivex.Observable;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class ShouModel {
    public Observable<ShouBean> getdata(){
        Observable<ShouBean> dataa = HttpUtils.instance().api.getDataa();
        return dataa;
    }
}
