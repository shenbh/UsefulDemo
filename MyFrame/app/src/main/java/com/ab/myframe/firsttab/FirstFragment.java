package com.ab.myframe.firsttab;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ab.myframe.R;
import com.ab.myframe.util.Constants;

public class FirstFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private TextView contentShowTv;

    public static FirstFragment getInstance(String content) {
        Bundle arguments = new Bundle();
        arguments.putString(Constants.EXTRA_CONTENT, content);
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setArguments(arguments);
        return firstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contextView = inflater.inflate(R.layout.fragment_first, container, false);
        contentShowTv = contextView.findViewById(R.id.content_show_tv);

        initListener();
        return contextView;
    }

    private void initListener() {
        if (null != contentShowTv) {
            contentShowTv.setOnClickListener(this);
        }
    }

    public void setText(int text) {
        if (null != contentShowTv) {
            contentShowTv.setText(text);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.content_show_tv:
                getActivity().startActivity(new Intent(getActivity(), TestNetRequestActivity.class));
                break;
            default:
                break;
        }
    }
}