package com.ab.myframe.base;

/**
 * Created by shenbinghong on 2018/3/9.
 */

public class BasePresenter<V extends BaseView> {
    private V mvpView;

    public void attachView(V view) {
        this.mvpView = view;
    }

    public void detachView() {
        this.mvpView = null;
    }

    public boolean isViewAttached() {
        return this.mvpView != null;
    }

    public V getView() {
        return this.mvpView;
    }
}
