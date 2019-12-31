package com.bawei.duanhaotao;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.duanhaotao.base.BaseActivity;
import com.bawei.duanhaotao.base.BasePresenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CodeActivity extends BaseActivity {
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.btnSc)
    Button btnSc;
    @BindView(R.id.CodeImage)
    ImageView CodeImage;
    @BindView(R.id.CodeQQ)
    Button CodeQQ;
    @BindView(R.id.CodeWei)
    Button CodeWei;
    private Unbinder bind;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
        CodeUtils.init(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_code;
    }

    @OnClick({R.id.btnSc, R.id.CodeImage, R.id.CodeQQ, R.id.CodeWei})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSc:
                if (editName.getText().toString()==null){
                    Toast.makeText(this, "不能为空"+editName.getText().toString(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Bitmap bitmap = CodeUtils.createImage(editName.getText().toString(),400,400,null);
                CodeImage.setImageBitmap(bitmap);
                break;
            case R.id.CodeImage:
                break;
            case R.id.CodeQQ:
                EventBus.getDefault().post(editName);
                break;
            case R.id.CodeWei:
                EventBus.getDefault().post("xiaohua");
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(EditText editText){
        Toast.makeText(this, ""+editText, Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!=null) {
            bind.unbind();
        }
        EventBus.getDefault().unregister(this);
    }
}
