package com.bawei.duanhaotao.base;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:06
 *@Description:${DESCRIPTION}
 **/

import com.bawei.duanhaotao.cretract.IBaseVeiw;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseVeiw> {
    public WeakReference<V>weakReference;
    public BasePresenter() {
        initMoudle();
    }
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    protected abstract void initMoudle();
    public V getView(){
        V v = weakReference.get();
        return v;
    }
}
