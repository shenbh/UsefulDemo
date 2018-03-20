package com.ab.myframe.model;

import android.os.Handler;

import com.ab.myframe.base.BaseModel;
import com.ab.myframe.base.Callback;
import com.ab.myframe.util.Constants;


/**
 * Created by shenbinghong on 2018/3/9.
 */

public class UserDataModel extends BaseModel<String> {

    @Override
    public void execute(final Callback<String> callback) {

        // 模拟网络请求耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mParams 是从父类得到的请求参数
                switch (mParams[0]) {
                    case Constants.TEST_NORMAL:
                        callback.onSuccess("根据参数" + mParams[0] + "的请求网络数据成功");
                        break;
                    case Constants.TEST_FAILURE:
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case Constants.TEST_ERROR:
                        callback.onError();
                        break;
                    default:
                        break;
                }
                callback.onComplete();
            }
        }, 2000);
    }
}
