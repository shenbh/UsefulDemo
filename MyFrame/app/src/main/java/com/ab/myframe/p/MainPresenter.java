package com.ab.myframe.p;


import com.ab.myframe.base.BasePresenter;
import com.ab.myframe.base.Callback;
import com.ab.myframe.base.DataModelDistribute;
import com.ab.myframe.model.Token;
import com.ab.myframe.view.MainView;

/**
 * Created by shenbinghong on 2018/3/9.
 */

public class MainPresenter extends BasePresenter<MainView> {
    /**
     * 获取网络数据
     *
     * @param params 参数
     */
    public void getData(String params) {
        if (!isViewAttached()) {
            //如果没有View引用就不加载数据
            return;
        }

        //显示正在加载进度条
        getView().showLoading();

        DataModelDistribute// 设置请求标识token
                .request(Token.API_USER_DATA)
                // 添加请求参数，没有则不添加
//                .params(userId)
                // 注册监听回调
                .execute(new Callback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        //调用view接口显示数据
                        if (isViewAttached()) {
                            getView().showData(data);
                        }
                    }

                    @Override
                    public void onFailure(String msg) {
                        //调用view接口提示失败信息
                        if (isViewAttached()) {
                            getView().showToast(msg);
                        }
                    }

                    @Override
                    public void onError() {
                        //调用view接口提示请求异常
                        if (isViewAttached()) {
                            getView().showErr();
                        }
                    }

                    @Override
                    public void onComplete() {
                        // 隐藏正在加载进度条
                        if (isViewAttached()) {
                            getView().hideLoading();
                        }
                    }
                });
    }
}
