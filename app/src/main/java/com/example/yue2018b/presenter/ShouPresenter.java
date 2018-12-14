package com.example.yue2018b.presenter;

import android.util.Log;


import com.example.yue2018b.model.ShouModel;
import com.example.yue2018b.model.bean.ShouBean;
import com.example.yue2018b.view.ivew.ShouView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class ShouPresenter extends BasePresenter<ShouView> {

    private final ShouModel shouModel;

    public ShouPresenter() {
        shouModel = new ShouModel();
    }

    public void shouData(){
        shouModel.getdata()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShouBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShouBean shouBean) {
                         if (shouBean!=null){
                             getview().onSuccess(shouBean);
                         }
                    }

                    @Override
                    public void onError(Throwable e) {

                   }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
