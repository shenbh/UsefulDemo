package com.ab.myframe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 类描述：ItemMineFragment我的
 * 创建人: shenbh Email:shenbh@qq.com
 * 创建时间： 2017/11/21 16:39
 * 修改人：
 * 修改时间：2017/11/21 16:39
 * 修改备注：
 *
 * @version 1.0
 */
public class TextFragment extends android.support.v4.app.Fragment {
    private TextView contentShowTv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contextView = inflater.inflate(R.layout.fragment_item, container, false);
        contentShowTv = contextView.findViewById(R.id.content_show_tv);
        return contextView;
    }

    public void setText(int text) {
        if (null != contentShowTv){
            contentShowTv.setText(text);
        }
    }
}