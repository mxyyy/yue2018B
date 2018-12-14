package com.example.yue2018b.model;



import com.example.yue2018b.model.bean.SecondBean;
import com.example.yue2018b.model.http.HttpUtils;

import io.reactivex.Observable;
/**
 * date:2018/12/21
 * author:mxy(M)
 * function:
 */

public class SecondModel {
    public Observable<SecondBean> getdataa(){
        Observable<SecondBean> dataaa = HttpUtils.instance().api.getDataaa();
        return dataaa;
    }
}
