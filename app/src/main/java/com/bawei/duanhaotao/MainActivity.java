package com.bawei.duanhaotao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.duanhaotao.adapter.MyAdapter;
import com.bawei.duanhaotao.base.BaseActivity;
import com.bawei.duanhaotao.bean.Bean;
import com.bawei.duanhaotao.cretract.ClassCretract;
import com.bawei.duanhaotao.presenter.PresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity<PresenterImpl> implements ClassCretract.ClassView {



    @BindView(R.id.Rv)
    RecyclerView Rv;
    private Unbinder bind;
    private MyAdapter adapter;

    @Override
    protected PresenterImpl initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initData() {
        presenter.Show();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object obj) {
        Bean bean = (Bean) obj;
        if (bean.getRanking().size() > 0) {
            List<Bean.RankingBean> ranking = bean.getRanking();
            adapter = new MyAdapter(ranking, this);
            Rv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
    @OnClick({R.id.OnClink, R.id.Rv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.OnClink:
                startActivity(new Intent(this,CodeActivity.class));
                break;
            case R.id.Rv:
                Toast.makeText(this, ""+adapter, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
