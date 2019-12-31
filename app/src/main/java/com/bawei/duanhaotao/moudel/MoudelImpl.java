package com.bawei.duanhaotao.moudel;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:25
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaotao.bean.Bean;
import com.bawei.duanhaotao.cretract.ApiService;
import com.bawei.duanhaotao.cretract.ClassCretract;
import com.bawei.duanhaotao.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MoudelImpl implements ClassCretract.ClassMoudel {
    @Override
    public void Show(DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Bean> observable = apiService.getResponse();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        callBack.success(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
