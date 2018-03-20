package com.ab.myframe;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ab.myframe.base.BaseActivity;
import com.ab.myframe.view.MainView;


/**
 * Created by shenbinghong on 2018/3/9.
 */

public class MainActivity extends BaseActivity implements MainView {
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
        presenter.getData("normal");
    }

    // button 点击事件调用方法
    public void getDataForFailure(View view) {
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view) {
        presenter.getData("error");
    }
}
