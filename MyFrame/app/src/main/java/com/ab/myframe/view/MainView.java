package com.ab.myframe.view;


import android.graphics.Bitmap;

import com.ab.myframe.base.BaseView;

/**视图层，数据传输
 * Created by shenbinghong on 2018/3/9.
 */

public interface MainView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);

//    void getView(String s);
//    void postView(String s);
//    void imgView(Bitmap bitmap);
}
