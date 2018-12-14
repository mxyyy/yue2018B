package com.example.yue2018b.model.http;



import com.example.yue2018b.model.bean.SecondBean;
import com.example.yue2018b.model.bean.ShouBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
public interface Api {
    @GET("restaurants_offset_0_limit_4")
    Observable<ShouBean> getDataa();
    @GET("restaurant-list")
    Observable<SecondBean> getDataaa();

}
