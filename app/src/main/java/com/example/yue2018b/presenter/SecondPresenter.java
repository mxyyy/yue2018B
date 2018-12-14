package com.example.yue2018b.presenter;



import com.example.yue2018b.model.SecondModel;
import com.example.yue2018b.model.bean.SecondBean;
import com.example.yue2018b.view.ivew.SecondView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class SecondPresenter extends BasePresenter<SecondView> {

    private final SecondModel secondModel;

    public SecondPresenter() {
        secondModel = new SecondModel();
    }
    public void twoData(){
        secondModel.getdataa()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SecondBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SecondBean secondBean) {
                          getview().onSuccess(secondBean);
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
