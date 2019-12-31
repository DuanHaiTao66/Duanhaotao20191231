package com.bawei.duanhaotao.cretract;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:27
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaotao.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/news/ranking.json")
    Observable<Bean>getResponse();
}
