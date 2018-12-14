package com.example.yue2018b.view.ivew;


import com.example.yue2018b.model.bean.SecondBean;

public interface SecondView extends BaseView {
    void onSuccess(SecondBean secondBean);
    void onError(Throwable e);
}
