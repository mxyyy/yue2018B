package com.example.yue2018b.view.ivew;


import com.example.yue2018b.model.bean.ShouBean;

public interface ShouView extends BaseView {
    void onSuccess(ShouBean shouBean);
    void onError(Throwable e);
}
