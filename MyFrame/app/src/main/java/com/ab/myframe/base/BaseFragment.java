package com.ab.myframe.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by shenbinghong on 2018/3/9.
 */

public abstract class BaseFragment extends Fragment implements BaseView {
    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle saveInstanceState);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).showLoading();
    }

    @Override
    public void showLoading(String msg) {
        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).showLoading(msg);
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).hideLoading();
    }

    @Override
    public void showToast(String msg) {
        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).showToast(msg);
    }

    @Override
    public void showErr() {
        checkActivityAttached();
//        ((BaseFragmentActivity) mContext).showErr();
    }


    protected boolean isAttachContext() {
        return getActivity() != null;
    }

    /**
     * 检查activity连接情况
     */
    protected void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNoAttachException();
        }
    }

    public static class ActivityNoAttachException extends RuntimeException {
        public ActivityNoAttachException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }
}
