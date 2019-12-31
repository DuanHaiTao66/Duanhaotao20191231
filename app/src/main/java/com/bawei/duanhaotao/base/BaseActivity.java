package com.bawei.duanhaotao.base;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:09
 *@Description:${DESCRIPTION}
 **/

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.duanhaotao.cretract.IBaseVeiw;

public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity implements IBaseVeiw {
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();

        }
    }
}
