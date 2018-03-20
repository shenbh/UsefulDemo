package com.ab.myframe.firsttab;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ab.myframe.p.MainPresenter;
import com.ab.myframe.R;
import com.ab.myframe.base.BaseActivity;
import com.ab.myframe.util.Constants;
import com.ab.myframe.view.MainView;


/**模拟网络请求（handler延迟）
 * Created by shenbinghong on 2018/3/9.
 */

public class TestNetRequestActivity extends BaseActivity implements MainView {
    TextView text;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        presenter = new MainPresenter();
        presenter.attachView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    // button 点击事件调用方法
    public void getData(View view) {
        presenter.getData(Constants.TEST_NORMAL);
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view) {
        presenter.getData(Constants.TEST_FAILURE);
    }

    // button 点击事件调用方法
    public void getDataForError(View view) {
        presenter.getData(Constants.TEST_ERROR);
    }
}
