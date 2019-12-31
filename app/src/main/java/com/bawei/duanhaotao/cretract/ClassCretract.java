package com.bawei.duanhaotao.cretract;
/*
 *@auther:段海涛
 *@Date: 2019-12-31
 *@Time:9:12
 *@Description:${DESCRIPTION}
 **/

public interface ClassCretract {
    interface ClassView extends IBaseVeiw{
        void success(Object obj);
        void filter(String msg);
    }
    interface ClassMoudel{
        void Show(DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface ClassPresenter{
        void Show();
    }
}
