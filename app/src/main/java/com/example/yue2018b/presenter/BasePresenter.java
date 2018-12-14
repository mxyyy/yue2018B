package com.example.yue2018b.presenter;


import com.example.yue2018b.view.ivew.BaseView;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class BasePresenter<V extends BaseView> {
    private V iv;

    public void attach(V iv) {
        this.iv = iv;
    }

    public void datach() {
        this.iv = null;
    }

    public V getview() {
        return iv;
    }
}
