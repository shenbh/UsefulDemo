package com.ab.myframe.secondtab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ab.myframe.R;
import com.ab.myframe.util.Constants;

public class SecondFragment extends android.support.v4.app.Fragment {
    private TextView contentShowTv;

    public static SecondFragment getInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(Constants.EXTRA_CONTENT, content);
        SecondFragment firstFragment = new SecondFragment();
        firstFragment.setArguments(arguments);
        return firstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contextView = inflater.inflate(R.layout.fragment_second, container, false);
        contentShowTv = contextView.findViewById(R.id.content_show_tv);
        return contextView;
    }

    public void setText(int text) {
        if (null != contentShowTv){
            contentShowTv.setText(text);
        }
    }
}