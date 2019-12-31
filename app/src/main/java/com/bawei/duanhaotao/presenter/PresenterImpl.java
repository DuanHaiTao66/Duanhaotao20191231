package com.bawei.duanhaotao.presenter;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:26
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaotao.base.BasePresenter;
import com.bawei.duanhaotao.cretract.ClassCretract;
import com.bawei.duanhaotao.moudel.MoudelImpl;

public class PresenterImpl extends BasePresenter<ClassCretract.ClassView>implements ClassCretract.ClassPresenter {

    private MoudelImpl moudel;

    @Override
    protected void initMoudle() {
        moudel = new MoudelImpl();
    }

    @Override
    public void Show() {
        moudel.Show(new ClassCretract.ClassMoudel.DataCallBack() {
            @Override
            public void success(Object obj) {
                getView().success(obj);
            }

            @Override
            public void filter(String msg) {
                getView().filter(msg);
            }
        });
    }
}
