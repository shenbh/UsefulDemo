package com.ab.myframe.thirdtab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ab.myframe.R;
import com.ab.myframe.util.Constants;

public class ThirdFragment extends android.support.v4.app.Fragment {
    private TextView contentShowTv;

    public static ThirdFragment getInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(Constants.EXTRA_CONTENT, content);
        ThirdFragment firstFragment = new ThirdFragment();
        firstFragment.setArguments(arguments);
        return firstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contextView = inflater.inflate(R.layout.fragment_third, container, false);
        contentShowTv = contextView.findViewById(R.id.content_show_tv);
        return contextView;
    }

    public void setText(int text) {
        if (null != contentShowTv){
            contentShowTv.setText(text);
        }
    }
}